package gov.anzong.util;

import gov.anzong.bean.DataBetter;
import gov.anzong.bean.M1905VideoDetialData;
import gov.anzong.bean.VideoDetialData;
import gov.anzong.bean.VideoParseJson;
import gov.anzong.bean.VideoTypeAdd;
import gov.anzong.fragment.ProgressDialogFragment;
import gov.anzong.mediaplayer.R;

import java.io.File;
import java.io.FileFilter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Locale;
import java.util.regex.Pattern;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.view.Display;

public class FunctionUtil {
	public static String uribase64(String uri) {
		uri = uri.replaceAll("://", ":##");
		uri = Base64.encodeToString(uri.getBytes(), Base64.NO_WRAP);
		uri = "http://api.flvxz.com/jsonp/purejson/url/" + uri;
		return uri;
	}

	public static String uriEncodeFlvcd(String uri, String format) {
		String newuri = "http://www.flvcd.com/parse.php?format=" + format
				+ "&kw=";
		try {
			uri = URLEncoder.encode(uri, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			return null;
		}
		return newuri + uri;
	}

	public static String videotitle(String title, String sitename, String from) {
		if (!StringUtil.isEmpty(title)) {
			title += " - ";
		}
		if (sitename == null) {
			sitename = "";
		}
		if (!StringUtil.isEmpty(from)) {
			title += from;
		} else {
			title += sitename;
		}
		return title;
	}

	public static boolean isjsondataempty(VideoDetialData[] jsondata) {
		if (jsondata == null) {
			return true;
		}
		if (jsondata.length == 0) {
			return true;
		}
		return false;
	}

	public static boolean isjsondataempty(M1905VideoDetialData[] jsondata) {
		if (jsondata == null) {
			return true;
		}
		if (jsondata.length == 0) {
			return true;
		}
		return false;
	}

	private static int getNumCores() {
		class CpuFilter implements FileFilter {
			@Override
			public boolean accept(File pathname) {
				if (Pattern.matches("cpu[0-9]", pathname.getName())) {
					return true;
				}
				return false;
			}
		}

		try {
			// Get directory containing CPU info
			File dir = new File("/sys/devices/system/cpu/");
			// Filter to only list the devices we care about
			File[] files = dir.listFiles(new CpuFilter());
			// Return the number of cores (virtual CPU devices)
			return files.length;
		} catch (Exception e) {
			// Default to return 1 core
			return 1;
		}
	}

	public static int minpixel(FragmentActivity context) {
		Display mDisplay = context.getWindowManager().getDefaultDisplay();
		int W = mDisplay.getWidth();
		int H = mDisplay.getHeight();
		if (W > H) {
			return H;
		} else {
			return W;
		}
	}

	public static int getvideohdformodel(FragmentActivity context) {
		int hd = 0;
		int Cores = getNumCores();
		if (Cores > 1) {// ���
			if (Cores > 2) {// �ĺ�����,���ֱ��ʰ�
				int minpixel = minpixel(context);
				if (minpixel >= 1080) {
					hd = 2;
				} else {
					hd = 1;
				}
			} else {// ˫�˿��ֱ��ʰ�
				int minpixel = minpixel(context);
				if (minpixel >= 720) {
					hd = 1;
				}
			}
		}
		String networkmode = getNetworkClass(context);
		switch (networkmode) {
		case "2G":
			hd = 0;
			break;
		case "3G":
			if (hd == 2)
				hd = 1;
			break;
		default:
			break;
		}
		return hd;
	}

	public static boolean isInWifi(Context mContext) {
		ConnectivityManager conMan = (ConnectivityManager) mContext
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		State wifi = conMan.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
				.getState();
		return wifi == State.CONNECTED;
	}

	public static boolean isConnected(Context mContext) {
		ConnectivityManager conMan = (ConnectivityManager) mContext
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo info = conMan.getActiveNetworkInfo();
		return (info != null && info.isConnected());
	}

	public static String getNetworkClass(Context mContext) {
		if (isInWifi(mContext)) {
			return "WIFI";
		}
		if (!isConnected(mContext)) {
			return "������";
		}
		TelephonyManager mTelephonyManager = (TelephonyManager) mContext
				.getSystemService(Context.TELEPHONY_SERVICE);
		int networkType = mTelephonyManager.getNetworkType();
		switch (networkType) {
		case TelephonyManager.NETWORK_TYPE_GPRS:
		case TelephonyManager.NETWORK_TYPE_EDGE:
		case TelephonyManager.NETWORK_TYPE_CDMA:
		case TelephonyManager.NETWORK_TYPE_1xRTT:
		case TelephonyManager.NETWORK_TYPE_IDEN:
			return "2G";
		case TelephonyManager.NETWORK_TYPE_UMTS:
		case TelephonyManager.NETWORK_TYPE_EVDO_0:
		case TelephonyManager.NETWORK_TYPE_EVDO_A:
		case TelephonyManager.NETWORK_TYPE_HSDPA:
		case TelephonyManager.NETWORK_TYPE_HSUPA:
		case TelephonyManager.NETWORK_TYPE_HSPA:
		case TelephonyManager.NETWORK_TYPE_EVDO_B:
		case TelephonyManager.NETWORK_TYPE_EHRPD:
		case TelephonyManager.NETWORK_TYPE_HSPAP:
			return "3G";
		case TelephonyManager.NETWORK_TYPE_LTE:
			return "4G";
		default:
			return "δ֪����";
		}
	}

	public static String videorealurl(VideoDetialData[] jsondata, String from,
			FragmentActivity context) {
		int hd = getvideohdformodel(context);
		VideoTypeAdd add = new VideoTypeAdd();
		String quality1 = null, quality2 = null;
		if (hd == 2) {
			switch (from) {
			case "�ſ���":// http://v.youku.com/v_show/id_XNzM0MTI2NDM2.html
			case "������":// http://www.tudou.com/albumplay/4Eo9FRy41pw/MTelMNxnomQ.html
				quality1 = "����M3U8";
				quality2 = "����M3U8";
				break;
			case "������":// http://www.letv.com/ptv/vplay/20218053.html
				quality1 = "1080pM3U8";
				quality2 = "����M3U8";
				break;
			case "56��":// http://www.56.com/u49/v_MTAwMjQ3OTY2.html
				quality1 = "super";
				quality2 = "normal";
				break;
			case "������":// http://v.ku6.com/show/HW9JjdBGdZYzTD-ivTIE5A...html?from=my
				quality1 = "����";
				quality2 = "����";
				break;
			case "��Ѷ��Ƶ":// http://v.qq.com/cover/c/ch4jk2ygsu95qtb.html
				quality1 = "����MP4";
				quality2 = "����MP4";
				break;
			case "����TV":// http://www.wasu.cn/Play/show/id/4231159
				break;
			case "PPS.tv":// http://v.pps.tv/play_3HC6NV.html
				quality1 = "1080PM3U8";
				quality2 = "����M3U8";
				break;
			case "����̨":// http://v.yinyuetai.com/video/2061385
				quality1 = "����";
				quality2 = "����";
				break;
			case "������":// http://www.iqiyi.com/v_19rrmo1540.html
				quality1 = "1080P";
				quality2 = "720P";
				break;
			case "CNTV":// http://tv.cntv.cn/video/C30881/75b026061ee849d09bdc2875d69dfc11
				quality1 = "����";
				quality2 = "����";
				break;
			case "�����":// http://v.ifeng.com/documentary/history/201111/21e5dc45-2330-4325-b0aa-3edfaef7caaf.shtml
				quality1 = "����";
				break;
			case "������Ƶ":
			case "���˹�����":
				quality1 = "����";
				quality1 = "����";
				break;
			default:
				break;
			}
		}
		if (quality1 == null && hd == 2) {// WASU����
			for (int i = 0; i < jsondata.length; i++) {
				if (jsondata[i].quality == null) {
					if (jsondata[i].files != null) {
						if (jsondata[i].files.length == 1) {// ������files��ֻ��һ��,Ȼ�����ѡ��
							switch (jsondata[i].files[0].ftype
									.toLowerCase(Locale.US)) {
							case "m3u8":
								add.m3u8add = jsondata[i].files[0].furl;
								break;
							case "mp4":
								add.mp4add = jsondata[i].files[0].furl;
								break;
							case "f4v":
								add.f4vadd = jsondata[i].files[0].furl;
								break;
							case "flv":
								add.flvadd = jsondata[i].files[0].furl;
								break;
							default:
								add.otheradd = jsondata[i].files[0].furl;
								break;
							}
						}
					}
				}
			}
		}
		if (add.hasadd()) {
			return add.rightadd();
		}
		if (!StringUtil.isEmpty(quality1) && hd == 2) {
			for (int i = 0; i < jsondata.length; i++) {
				if (jsondata[i].quality.toLowerCase(Locale.CHINA).equals(
						quality1.toLowerCase(Locale.CHINA))) {
					if (jsondata[i].files != null) {
						if (jsondata[i].files.length == 1) {// ������files��ֻ��һ��,Ȼ�����ѡ��
							switch (jsondata[i].files[0].ftype
									.toLowerCase(Locale.US)) {
							case "m3u8":
								add.m3u8add = jsondata[i].files[0].furl;
								break;
							case "mp4":
								add.mp4add = jsondata[i].files[0].furl;
								break;
							case "f4v":
								add.f4vadd = jsondata[i].files[0].furl;
								break;
							case "flv":
								add.flvadd = jsondata[i].files[0].furl;
								break;
							default:
								add.otheradd = jsondata[i].files[0].furl;
								break;
							}
						}
					}
				}
			}
		}
		if (add.hasadd()) {
			return add.rightadd();
		}
		if (!StringUtil.isEmpty(quality2) && hd == 2) {
			for (int i = 0; i < jsondata.length; i++) {
				if (jsondata[i].quality.toLowerCase(Locale.CHINA).equals(
						quality2.toLowerCase(Locale.CHINA))) {
					if (jsondata[i].files != null) {
						if (jsondata[i].files.length == 1) {// ������files��ֻ��һ��,Ȼ�����ѡ��
							switch (jsondata[i].files[0].ftype
									.toLowerCase(Locale.US)) {
							case "m3u8":
								add.m3u8add = jsondata[i].files[0].furl;
								break;
							case "mp4":
								add.mp4add = jsondata[i].files[0].furl;
								break;
							case "f4v":
								add.f4vadd = jsondata[i].files[0].furl;
								break;
							case "flv":
								add.flvadd = jsondata[i].files[0].furl;
								break;
							default:
								add.otheradd = jsondata[i].files[0].furl;
								break;
							}
						}
					}
				}
			}
		}
		if (add.hasadd()) {
			return add.rightadd();
		} else if (hd == 2) {
			hd = 1;
		}
		if (hd == 1) {
			switch (from) {
			case "�ſ���":
			case "������":
				quality1 = "����M3U8";
				quality2 = "MP4��ʽM3U8";
				break;
			case "������":
				quality1 = "����M3U8";
				quality2 = "����";
				break;
			case "56��":
				quality1 = "normal";
				quality2 = "clear";
			case "������":
				quality1 = "����";
				quality2 = "M3U8";
			case "��Ѷ��Ƶ":
				quality1 = "����MP4";
				quality2 = "����MP4";
				break;
			case "����TV":
				break;
			case "PPS.tv":
				quality1 = "720PM3U8";
				quality2 = "����M3U8";
				break;
			case "����̨":
				quality1 = "����";
				quality2 = "����";
				break;
			case "������":
				quality1 = "720P";
				quality2 = "����";
				break;
			case "CNTV":
				quality1 = "����";
				quality2 = "M3U8";
				break;
			case "�����":
				quality1 = "����";
				break;
			case "������Ƶ":
			case "���˹�����":
				quality1 = "����";
				quality1 = "MP4";
				break;
			default:
				break;
			}
		}
		if (quality1 == null && hd == 1) {// WASU����
			for (int i = 0; i < jsondata.length; i++) {
				if (jsondata[i].quality == null) {
					if (jsondata[i].files != null) {
						if (jsondata[i].files.length == 1) {// ������files��ֻ��һ��,Ȼ�����ѡ��
							switch (jsondata[i].files[0].ftype
									.toLowerCase(Locale.US)) {
							case "m3u8":
								add.m3u8add = jsondata[i].files[0].furl;
								break;
							case "mp4":
								add.mp4add = jsondata[i].files[0].furl;
								break;
							case "f4v":
								add.f4vadd = jsondata[i].files[0].furl;
								break;
							case "flv":
								add.flvadd = jsondata[i].files[0].furl;
								break;
							default:
								add.otheradd = jsondata[i].files[0].furl;
								break;
							}
						}
					}
				}
			}
		}
		if (add.hasadd()) {
			return add.rightadd();
		}
		if (!StringUtil.isEmpty(quality1) && hd == 1) {
			for (int i = 0; i < jsondata.length; i++) {
				if (jsondata[i].quality.toLowerCase(Locale.CHINA).equals(
						quality1.toLowerCase(Locale.CHINA))) {
					if (jsondata[i].files != null) {
						if (jsondata[i].files.length == 1) {// ������files��ֻ��һ��,Ȼ�����ѡ��
							switch (jsondata[i].files[0].ftype
									.toLowerCase(Locale.US)) {
							case "m3u8":
								add.m3u8add = jsondata[i].files[0].furl;
								break;
							case "mp4":
								add.mp4add = jsondata[i].files[0].furl;
								break;
							case "f4v":
								add.f4vadd = jsondata[i].files[0].furl;
								break;
							case "flv":
								add.flvadd = jsondata[i].files[0].furl;
								break;
							default:
								add.otheradd = jsondata[i].files[0].furl;
								break;
							}
						}
					}
				}
			}
		}
		if (add.hasadd()) {
			return add.rightadd();
		}
		if (!StringUtil.isEmpty(quality2) && hd == 1) {
			for (int i = 0; i < jsondata.length; i++) {
				if (jsondata[i].quality.toLowerCase(Locale.CHINA).equals(
						quality2.toLowerCase(Locale.CHINA))) {
					if (jsondata[i].files != null) {
						if (jsondata[i].files.length == 1) {// ������files��ֻ��һ��,Ȼ�����ѡ��
							switch (jsondata[i].files[0].ftype
									.toLowerCase(Locale.US)) {
							case "m3u8":
								add.m3u8add = jsondata[i].files[0].furl;
								break;
							case "mp4":
								add.mp4add = jsondata[i].files[0].furl;
								break;
							case "f4v":
								add.f4vadd = jsondata[i].files[0].furl;
								break;
							case "flv":
								add.flvadd = jsondata[i].files[0].furl;
								break;
							default:
								add.otheradd = jsondata[i].files[0].furl;
								break;
							}
						}
					}
				}
			}
		}
		if (add.hasadd()) {
			return add.rightadd();
		} else if (hd == 1) {
			hd = 0;
		}
		if (hd == 0) {
			switch (from) {
			case "�ſ���":
			case "������":
				quality1 = "MP4��ʽM3U8";
				quality2 = "�ֻ�����";
				break;
			case "������":
				quality1 = "����M3U8";
				quality2 = "����";
				break;
			case "56��":
				quality1 = "clear";
				quality2 = null;
			case "������":
				quality1 = "M3U8";
				quality2 = "����";
			case "��Ѷ��Ƶ":
				quality1 = "����";
				quality2 = "����MP4";
				break;
			case "����TV":
				break;
			case "PPS.tv":
				quality1 = "����M3U8";
				quality2 = "����M3U8";
				break;
			case "����̨":
				quality1 = "����";
				quality2 = null;
				break;
			case "������":
				quality1 = "mp4";
				quality2 = "m3u8";
				break;
			case "CNTV":
				quality1 = "����";
				quality2 = "M3U8";
				break;
			case "�����":
				quality1 = "����";
				break;
			case "������Ƶ":
			case "���˹�����":
				quality1 = "����";
				quality1 = "MP4";
				break;
			default:
				break;
			}
		}
		if (quality1 == null && hd == 0) {// WASU����
			for (int i = 0; i < jsondata.length; i++) {
				if (jsondata[i].quality == null) {
					if (jsondata[i].files != null) {
						if (jsondata[i].files.length == 1) {// ������files��ֻ��һ��,Ȼ�����ѡ��
							switch (jsondata[i].files[0].ftype
									.toLowerCase(Locale.US)) {
							case "m3u8":
								add.m3u8add = jsondata[i].files[0].furl;
								break;
							case "mp4":
								add.mp4add = jsondata[i].files[0].furl;
								break;
							case "f4v":
								add.f4vadd = jsondata[i].files[0].furl;
								break;
							case "flv":
								add.flvadd = jsondata[i].files[0].furl;
								break;
							default:
								add.otheradd = jsondata[i].files[0].furl;
								break;
							}
						}
					}
				}
			}
		}
		if (add.hasadd()) {
			return add.rightadd();
		}
		if (!StringUtil.isEmpty(quality1) && hd == 0) {
			for (int i = 0; i < jsondata.length; i++) {
				if (jsondata[i].quality.toLowerCase(Locale.CHINA).equals(
						quality1.toLowerCase(Locale.CHINA))) {
					if (jsondata[i].files != null) {
						if (jsondata[i].files.length == 1) {// ������files��ֻ��һ��,Ȼ�����ѡ��
							switch (jsondata[i].files[0].ftype
									.toLowerCase(Locale.US)) {
							case "m3u8":
								add.m3u8add = jsondata[i].files[0].furl;
								break;
							case "mp4":
								add.mp4add = jsondata[i].files[0].furl;
								break;
							case "f4v":
								add.f4vadd = jsondata[i].files[0].furl;
								break;
							case "flv":
								add.flvadd = jsondata[i].files[0].furl;
								break;
							default:
								add.otheradd = jsondata[i].files[0].furl;
								break;
							}
						}
					}
				}
			}
		}
		if (add.hasadd()) {
			return add.rightadd();
		}
		if (!StringUtil.isEmpty(quality2) && hd == 0) {
			for (int i = 0; i < jsondata.length; i++) {
				if (jsondata[i].quality.toLowerCase(Locale.CHINA).equals(
						quality2.toLowerCase(Locale.CHINA))) {
					if (jsondata[i].files != null) {
						if (jsondata[i].files.length == 1) {// ������files��ֻ��һ��,Ȼ�����ѡ��
							switch (jsondata[i].files[0].ftype
									.toLowerCase(Locale.US)) {
							case "m3u8":
								add.m3u8add = jsondata[i].files[0].furl;
								break;
							case "mp4":
								add.mp4add = jsondata[i].files[0].furl;
								break;
							case "f4v":
								add.f4vadd = jsondata[i].files[0].furl;
								break;
							case "flv":
								add.flvadd = jsondata[i].files[0].furl;
								break;
							default:
								add.otheradd = jsondata[i].files[0].furl;
								break;
							}
						}
					}
				}
			}
		}
		if (add.hasadd()) {
			return add.rightadd();
		}
		for (int i = 0; i < jsondata.length; i++) {
			if (jsondata[i].files != null) {
				if (jsondata[i].files.length == 1) {// ������files��ֻ��һ��,Ȼ�����ѡ��
					switch (jsondata[i].files[0].ftype.toLowerCase(Locale.US)) {
					case "m3u8":
						add.m3u8add = jsondata[i].files[0].furl;
						break;
					case "mp4":
						add.mp4add = jsondata[i].files[0].furl;
						break;
					case "f4v":
						add.f4vadd = jsondata[i].files[0].furl;
						break;
					case "flv":
						add.flvadd = jsondata[i].files[0].furl;
						break;
					default:
						add.otheradd = jsondata[i].files[0].furl;
						break;
					}
				}
			}
		}
		if (add.hasadd()) {
			return add.rightadd();
		}
		for (int i = 0; i < jsondata.length; i++) {
			if (jsondata[i].files != null) {
				if (jsondata[i].files.length > 1) {// ������files��ֻ��һ��,Ȼ�����ѡ��
					switch (jsondata[i].files[0].ftype.toLowerCase(Locale.US)) {
					case "m3u8":
						add.m3u8add = jsondata[i].files[0].furl;
						break;
					case "mp4":
						add.mp4add = jsondata[i].files[0].furl;
						break;
					case "f4v":
						add.f4vadd = jsondata[i].files[0].furl;
						break;
					case "flv":
						add.flvadd = jsondata[i].files[0].furl;
						break;
					default:
						add.otheradd = jsondata[i].files[0].furl;
						break;
					}
				}
			}
		}
		return add.rightadd();
	}

	public static DataBetter dataselectbetterone(String js, String from,
			FragmentActivity context) {
		DataBetter databetter = new DataBetter();
		if (StringUtil.isEmpty(js)) {
			databetter.errorcode = 1;
			return databetter;
		}
		try {
			VideoDetialData[] jsondata = VideoParseJson.parseRead(js);
			if (FunctionUtil.isjsondataempty(jsondata)) {
				databetter.errorcode = 2;
				return databetter;
			}
			String title = jsondata[0].title;
			String sitename = jsondata[0].site;
			title = FunctionUtil.videotitle(title, sitename, from);
			String url = videorealurl(jsondata, from, context);
			if (StringUtil.isEmpty(url)) {
				databetter.errorcode = 2;
				return databetter;
			} else {
				databetter.errorcode = -1;
				databetter.title = title;
				databetter.url = url;
				return databetter;
			}
		} catch (Exception e) {
			databetter.errorcode = 2;
			return databetter;
		}
	}

	public static String videorealurl(M1905VideoDetialData[] jsondata,
			FragmentActivity context) {

		int hd = 0;
		int Cores = getNumCores();
		if (Cores > 1) {// ���
			if (Cores > 2) {// �ĺ�����,���ֱ��ʰ�
				int minpixel = minpixel(context);
				if (minpixel >= 1080) {
					hd = 2;
				} else {
					hd = 1;
				}
			} else {// ˫�˿��ֱ��ʰ�
				int minpixel = minpixel(context);
				if (minpixel >= 720) {
					hd = 1;
				}
			}
		}
		VideoTypeAdd add = new VideoTypeAdd();
		String quality1 = null;
		if (hd == 2) {
			quality1 = "����";
		}
		if (!StringUtil.isEmpty(quality1) && hd == 2) {
			for (int i = 0; i < jsondata.length; i++) {
				if (jsondata[i].quality.toLowerCase(Locale.CHINA).equals(
						quality1.toLowerCase(Locale.CHINA))) {
					if (jsondata[i].files != null) {
						if (jsondata[i].files.length == 1) {// ������files��ֻ��һ��,Ȼ�����ѡ��
							switch (jsondata[i].files[0].ftype
									.toLowerCase(Locale.US)) {
							case "m3u8":
								add.m3u8add = jsondata[i].files[0].furl;
								break;
							case "mp4":
								add.mp4add = jsondata[i].files[0].furl;
								break;
							case "f4v":
								add.f4vadd = jsondata[i].files[0].furl;
								break;
							case "flv":
								add.flvadd = jsondata[i].files[0].furl;
								break;
							default:
								add.otheradd = jsondata[i].files[0].furl;
								break;
							}
						}
					}
				}
			}
		}
		if (add.hasadd()) {
			return add.rightadd();
		} else if (hd == 2) {
			hd = 1;
		}
		if (hd == 1) {
			quality1 = "����";
		}
		if (!StringUtil.isEmpty(quality1) && hd == 1) {
			for (int i = 0; i < jsondata.length; i++) {
				if (jsondata[i].quality.toLowerCase(Locale.CHINA).equals(
						quality1.toLowerCase(Locale.CHINA))) {
					if (jsondata[i].files != null) {
						if (jsondata[i].files.length == 1) {// ������files��ֻ��һ��,Ȼ�����ѡ��
							switch (jsondata[i].files[0].ftype
									.toLowerCase(Locale.US)) {
							case "m3u8":
								add.m3u8add = jsondata[i].files[0].furl;
								break;
							case "mp4":
								add.mp4add = jsondata[i].files[0].furl;
								break;
							case "f4v":
								add.f4vadd = jsondata[i].files[0].furl;
								break;
							case "flv":
								add.flvadd = jsondata[i].files[0].furl;
								break;
							default:
								add.otheradd = jsondata[i].files[0].furl;
								break;
							}
						}
					}
				}
			}
		}
		if (add.hasadd()) {
			return add.rightadd();
		} else if (hd == 1) {
			hd = 0;
		}
		if (hd == 0) {
			quality1 = "����";
		}
		if (!StringUtil.isEmpty(quality1) && hd == 0) {
			for (int i = 0; i < jsondata.length; i++) {
				if (jsondata[i].quality.toLowerCase(Locale.CHINA).equals(
						quality1.toLowerCase(Locale.CHINA))) {
					if (jsondata[i].files != null) {
						if (jsondata[i].files.length == 1) {// ������files��ֻ��һ��,Ȼ�����ѡ��
							switch (jsondata[i].files[0].ftype
									.toLowerCase(Locale.US)) {
							case "m3u8":
								add.m3u8add = jsondata[i].files[0].furl;
								break;
							case "mp4":
								add.mp4add = jsondata[i].files[0].furl;
								break;
							case "f4v":
								add.f4vadd = jsondata[i].files[0].furl;
								break;
							case "flv":
								add.flvadd = jsondata[i].files[0].furl;
								break;
							default:
								add.otheradd = jsondata[i].files[0].furl;
								break;
							}
						}
					}
				}
			}
		}
		if (add.hasadd()) {
			return add.rightadd();
		}
		for (int i = 0; i < jsondata.length; i++) {
			if (jsondata[i].files != null) {
				if (jsondata[i].files.length == 1) {// ������files��ֻ��һ��,Ȼ�����ѡ��
					switch (jsondata[i].files[0].ftype.toLowerCase(Locale.US)) {
					case "m3u8":
						add.m3u8add = jsondata[i].files[0].furl;
						break;
					case "mp4":
						add.mp4add = jsondata[i].files[0].furl;
						break;
					case "f4v":
						add.f4vadd = jsondata[i].files[0].furl;
						break;
					case "flv":
						add.flvadd = jsondata[i].files[0].furl;
						break;
					default:
						add.otheradd = jsondata[i].files[0].furl;
						break;
					}
				}
			}
		}
		return add.rightadd();
	}

	public static String videorealurlted(VideoDetialData[] jsondata,
			FragmentActivity context) {

		int hd = 0;
		int Cores = getNumCores();
		if (Cores > 1) {// ���
			if (Cores > 2) {// �ĺ�����,���ֱ��ʰ�
				int minpixel = minpixel(context);
				if (minpixel >= 1080) {
					hd = 2;
				} else {
					hd = 1;
				}
			} else {// ˫�˿��ֱ��ʰ�
				int minpixel = minpixel(context);
				if (minpixel >= 720) {
					hd = 1;
				}
			}
		}
		VideoTypeAdd add = new VideoTypeAdd();
		String quality1 = null;
		if (hd == 2) {
			quality1 = "480p.mp4";
		}
		if (!StringUtil.isEmpty(quality1) && hd == 2) {
			for (int i = 0; i < jsondata.length; i++) {
				if (jsondata[i].files != null) {
					if (jsondata[i].files.length == 1) {// ������files��ֻ��һ��,Ȼ�����ѡ��
						if (jsondata[i].files[0].ftype.toLowerCase(Locale.US)
								.indexOf(quality1) >= 0) {
							switch (jsondata[i].files[0].ftype
									.toLowerCase(Locale.US)) {
							case "m3u8":
								add.m3u8add = jsondata[i].files[0].furl;
								break;
							case "mp4":
								add.mp4add = jsondata[i].files[0].furl;
								break;
							case "f4v":
								add.f4vadd = jsondata[i].files[0].furl;
								break;
							case "flv":
								add.flvadd = jsondata[i].files[0].furl;
								break;
							default:
								add.otheradd = jsondata[i].files[0].furl;
								break;
							}
						}
					}
				}
			}
		}
		if (add.hasadd()) {
			return add.rightadd();
		} else if (hd == 2) {
			hd = 1;
		}
		if (hd == 1) {
			quality1 = "s.mp4";
		}
		if (!StringUtil.isEmpty(quality1) && hd == 1) {
			for (int i = 0; i < jsondata.length; i++) {
				if (jsondata[i].files != null) {
					if (jsondata[i].files.length == 1) {// ������files��ֻ��һ��,Ȼ�����ѡ��
						if (jsondata[i].files[0].ftype.toLowerCase(Locale.US)
								.indexOf(quality1) >= 0) {
							switch (jsondata[i].files[0].ftype
									.toLowerCase(Locale.US)) {
							case "m3u8":
								add.m3u8add = jsondata[i].files[0].furl;
								break;
							case "mp4":
								add.mp4add = jsondata[i].files[0].furl;
								break;
							case "f4v":
								add.f4vadd = jsondata[i].files[0].furl;
								break;
							case "flv":
								add.flvadd = jsondata[i].files[0].furl;
								break;
							default:
								add.otheradd = jsondata[i].files[0].furl;
								break;
							}
						}
					}
				}
			}
		}
		if (add.hasadd()) {
			return add.rightadd();
		} else if (hd == 1) {
			hd = 0;
		}
		if (hd == 0) {
			quality1 = "s-320k.mp4";
		}
		if (!StringUtil.isEmpty(quality1) && hd == 0) {
			for (int i = 0; i < jsondata.length; i++) {
				if (jsondata[i].files != null) {
					if (jsondata[i].files.length == 1) {// ������files��ֻ��һ��,Ȼ�����ѡ��
						if (jsondata[i].files[0].ftype.toLowerCase(Locale.US)
								.indexOf(quality1) >= 0) {
							switch (jsondata[i].files[0].ftype
									.toLowerCase(Locale.US)) {
							case "m3u8":
								add.m3u8add = jsondata[i].files[0].furl;
								break;
							case "mp4":
								add.mp4add = jsondata[i].files[0].furl;
								break;
							case "f4v":
								add.f4vadd = jsondata[i].files[0].furl;
								break;
							case "flv":
								add.flvadd = jsondata[i].files[0].furl;
								break;
							default:
								add.otheradd = jsondata[i].files[0].furl;
								break;
							}
						}
					}
				}
			}
		}
		if (add.hasadd()) {
			return add.rightadd();
		}
		for (int i = 0; i < jsondata.length; i++) {
			if (jsondata[i].files != null) {
				if (jsondata[i].files.length == 1) {// ������files��ֻ��һ��,Ȼ�����ѡ��
					switch (jsondata[i].files[0].ftype.toLowerCase(Locale.US)) {
					case "m3u8":
						add.m3u8add = jsondata[i].files[0].furl;
						break;
					case "mp4":
						add.mp4add = jsondata[i].files[0].furl;
						break;
					case "f4v":
						add.f4vadd = jsondata[i].files[0].furl;
						break;
					case "flv":
						add.flvadd = jsondata[i].files[0].furl;
						break;
					default:
						add.otheradd = jsondata[i].files[0].furl;
						break;
					}
				}
			}
		}
		return add.rightadd();
	}

	public static void createdialog(FragmentActivity context, String dialogTag) {
		ProgressDialogFragment pd = new ProgressDialogFragment();

		Bundle args = new Bundle();
		final String content = context.getResources().getString(
				R.string.load_please_wait);
		args.putString("content", content);
		pd.setArguments(args);
		pd.show(context.getSupportFragmentManager(), dialogTag);
	}

	public static void closedialog(FragmentActivity context, String dialogTag) {

		FragmentManager fm = context.getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();

		Fragment prev = fm.findFragmentByTag(dialogTag);
		if (prev != null) {
			ft.remove(prev);
		}
		try {
			ft.commit();
		} catch (Exception e) {
		}
	}

}
