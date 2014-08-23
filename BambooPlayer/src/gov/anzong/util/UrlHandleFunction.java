package gov.anzong.util;

import java.util.Locale;

import android.util.Log;

import gov.anzong.bean.VideoUrlHandle;

public class UrlHandleFunction {

	static private final String YOUKUSWF_START = "http://player.youku.com/player.php/";
	static private final String YOUKUSWF2_START = "http://static.youku.com/";
	static private final String YOUKUSWF3_START = "http://player.youku.com/embed/";
	static private final String YOUKU_START = "http://v.youku.com/v_show/id_";

	static private final String TUDOU_START = "http://www.tudou.com/programs/view/";
	static private final String TUDOUWITHOUTWWW_START = "http://tudou.com/programs/view/";
	static private final String TUDOUSWF_START = "http://www.tudou.com/v/";
	static private final String TUDOUSWFWITHOUTWWW_START = "http://tudou.com/v/";
	static private final String TUDOU_ALBUM_START = "http://www.tudou.com/albumplay/";

	static private final String A56_START = "http://www.56.com/u";
	static private final String A56WITHOUTWWW_START = "http://56.com/u";
	static private final String A56SWF_START = "http://player.56.com/v_";
	static private final String A56SWF2_START = "http://www.56.com/flashapp/out";
	static private final String A56SWF2_NOWWW_START = "http://56.com/flashapp/out";
	

	static private final String KU6_START = "http://v.ku6.com/show/";
	static private final String KU6SWF_START = "http://player.ku6.com/refer/";
	static private final String KU6CDNSWF_START = "http://player.ku6cdn.com/default/loader/";

	static private final String LETV_START = "http://www.letv.com/ptv/";// ȷ��û��www�ǲ��е�
	static private final String LETV_NOWWW_START = "http://letv.com/ptv/";// ȷ��û��www�ǲ��е�
	static private final String LETVSWF_INCLUDE = "letv.com/player/swfplayer.swf";

	static private final String QQ_START = "http://v.qq.com/";
	static private final String QQSWF_START = "http://static.video.qq.com/TPout.swf";

	static private final String WASU_START = "http://www.wasu.cn/play/show/id/";// ȷ��û��www�ǲ��е�
	static private final String WASU_NOWWW_START = "http://wasu.cn/play/show/id/";// ȷ��û��www�ǲ��е�

	static private final String YOUTUBE_WITH = "http://www.youtube.com/watch?v=";
	static private final String YOUTUBENOWWW_WITH = "http://youtube.com/watch?v=";
	static private final String YOUTUBESHARE_START = "http://youtu.be/";
	static private final String YOUTUBESHAREEMBED_START = "http://www.youtube.com/embed/";
	static private final String YOUTUBESHAREEMBEDNOWWW_START = "http://youtube.com/embed/";
	static private final String YOUTUBESHAREEMBEDNOCOOKIE_START = "http://www.youtube-nocookie.com/embed/";
	static private final String YOUTUBESHAREEMBEDNOCOOKIENOWWW_START = "http://youtube-nocookie.com/embed/";
	static private final String YOUTUBESHAREEMBEDOLD_START = "http://www.youtube.com/v/";
	static private final String YOUTUBESHAREEMBEDNOWWWOLD_START = "http://youtube.com/v/";
	static private final String YOUTUBESHAREEMBEDNOCOOKIEOLD_START = "http://www.youtube-nocookie.com/v/";
	static private final String YOUTUBESHAREEMBEDNOCOOKIENOWWWOLD_START = "http://youtube-nocookie.com/v/";
	static private final String YOUTUBE_END = "?";
	
	static private final String CNTV_START = "http://tv.cntv.cn/video/";
	
	static private final String NETEASE_START = "http://v.163.com/";// ȷ��û��www�ǲ��е�
	static private final String NETEASEGAME_START = "http://v.game.163.com/video/";// ȷ��û��www�ǲ��е�
	static private final String NETEASEOPEN_START = "http://open.163.com/movie/";
	
	static private final String BILIBILI_START = "http://www.bilibili.tv/video/av";
	static private final String BILIBILINOWWW_START = "http://bilibili.tv/video/av";
	static private final String BILIBILICOM_START = "http://www.bilibili.com/video/av";
	static private final String BILIBILICOMNOWWW_START = "http://bilibili.com/video/av";
	static private final String BILIBILI2_START = "http://bilibili.kankanews.com/video/av";
	static private final String BILIBILICID_START = "https://secure.bilibili.tv/secure,";
	static private final String BILIBILICID_END = "&";
	static private final String BILIBILI_SHAREACGTV_START = "http://share.acg.tv/av";
	static private final String BILIBILI_SHAREACGTV_FLASH_START = "http://share.acg.tv/flash.swf";
	static private final String BILIBILI_SHAREACGTV_FLASH_END = "&";
	static private final String BILIBILI_HDSLB_FLASH_START = "http://static.hdslb.com/miniloader.swf";
	static private final String BILIBILI_HDSLB_FLASH_END = "&";
	static private final String BILIBILI_MACGTV_START = "http://m.acg.tv/video/av";
	static private final String BILIBILI_MACGTV_END = ".html";
	static private final String BILIBILI_SUPERLINK = "bilibili://?av=";

	static private final String YINYUETAI_START = "http://v.yinyuetai.com/v";
	
	static private final String PPS_START = "http://v.pps.tv/play_";
	static private final String PPSSWF_START = "http://player.pps.tv/player/sid/";

	static private final String SINA_START = "http://video.sina.com.cn/";
	static private final String SINAOPEN_START = "http://open.sina.com.cn/course/";
	static private final String SINATV_START = "http://tv.video.sina.com.cn/play/";

	static private final String IQIYI_START = "http://www.iqiyi.com/";
	static private final String IQIYINOWWW_START = "http://iqiyi.com/";
	static private final String IQIYI_SWF_START = "http://player.video.qiyi.com/";
	static private final String IQIYI_SWF2_START = "http://www.iqiyi.com/common/flashplayer/";
	static private final String IQIYI_SWF2_NOWWW_START = "http://iqiyi.com/common/flashplayer/";
	static private final String IQIYI_QPLAY_START = "http://www.iqiyi.com/common/qplay.html?";
	static private final String IQIYI_QPLAY_NOWWW_START = "http://iqiyi.com/common/qplay.html?";

	static private final String ACFUN_START = "http://www.acfun.com/v/ac";
	static private final String ACFUNNOWWW_START = "http://acfun.com/v/ac";
	static private final String ACFUNSWF_START = "http://static.acfun.com/player/ACFlashPlayer.out.swf";
	static private final String ACFUNTV_START = "http://www.acfun.tv/v/ac";
	static private final String ACFUNTVNOWWW_START = "http://acfun.tv/v/ac";
	static private final String ACFUNTVSWF_START = "http://static.acfun.tv/player/ACFlashPlayer.out.swf";

	static private final String MYSOHU_END = ".shtml";
	static private final String MYSOHU_START = "http://my.tv.sohu.com/u/";
	static private final String MYSOHU2_END = ".shtml";
	static private final String MYSOHU2_START = "http://my.tv.sohu.com/us/";
	static private final String SOHU_START = "http://tv.sohu.com/";
	static private final String SOHUSWF_END = "/v.swf";
	static private final String SOHUSWF_START = "http://share.vrs.sohu.com/";
	static private final String MYSOHUSWF_START = "http://share.vrs.sohu.com/my/v.swf";
	static private final String SOHUNEWLINK_START = "http://tv.sohu.com/upload/static/share/";

	static private final String YOUXIA_START = "http://v.ali213.net/video/";

	static private final String M1905_START = "http://www.1905.com/vod/play/";
	static private final String M1905NOWWW_START = "http://1905.com/vod/play/";

	static private final String TED_TALK_START = "http://www.ted.com/talks/";
	static private final String TED_TALK_NOWWW_START = "http://ted.com/talks/";
	
	static private final String IFENGVIDEO_START = "http://v.ifeng.com/";
	
	
	

	static VideoUrlHandle returndata = new VideoUrlHandle();

	public static final VideoUrlHandle HandleUrl(String origurl) {
		final String url = origurl.toLowerCase(Locale.US);
		/* �ſ���У�� */
		if (url.startsWith(YOUKU_START) || url.startsWith(YOUKUSWF_START)
				|| url.startsWith(YOUKUSWF2_START)
				|| url.startsWith(YOUKUSWF3_START)) {
			returndata.urladd = origurl;
			returndata.from = "�ſ���";
			return returndata;
		}

		/* ������У�� */
		if (url.startsWith(TUDOU_START)
				|| url.startsWith(TUDOUWITHOUTWWW_START)
				|| url.startsWith(TUDOUSWF_START)
				|| url.startsWith(TUDOU_ALBUM_START)) {
			returndata.urladd = origurl;
			returndata.from = "������";
			return returndata;
		}
		if (url.startsWith(TUDOUSWFWITHOUTWWW_START)) {
			returndata.urladd = origurl.replace("//tudou", "//www.tudou");
			returndata.from = "������";
			return returndata;
		}

		/* 56��У�� */
		if (url.startsWith(A56_START) || url.startsWith(A56SWF_START)||url.startsWith(A56SWF2_START)) {// ͨ��JSON��ȡ��ַ
			returndata.urladd = origurl;
			returndata.from = "56��";
			return returndata;
		}
		if (url.startsWith(A56WITHOUTWWW_START) || url.startsWith(A56SWF2_NOWWW_START)) {// ͨ��JSON��ȡ��ַ
			returndata.urladd = origurl.replace("//56", "//www.56");
			returndata.from = "56��";
			return returndata;
		}

		/* ������У�� */
		if (url.startsWith(KU6_START) || url.startsWith(KU6SWF_START) || url.startsWith(KU6CDNSWF_START)) {
			returndata.urladd = origurl;
			returndata.from = "������";
			return returndata;
		}

		/* ������У�� */
		if (url.startsWith(LETV_START)
				|| url.indexOf(LETVSWF_INCLUDE.toLowerCase(Locale.US)) > 0) {
			returndata.urladd = origurl;
			returndata.from = "������";
			returndata.needotherhandle=true;
			returndata.handlesite="letv";
			return returndata;
		}
		/* ������У�� */
		if (url.startsWith(LETV_NOWWW_START)) {
			returndata.urladd = origurl.replace("//le", "//www.le");
			returndata.from = "������";
			returndata.needotherhandle=true;
			returndata.handlesite="letv";
			return returndata;
		}

		/* ��Ѷ��У�� */
		if ((url.startsWith(QQ_START) || url.indexOf(QQSWF_START
				.toLowerCase(Locale.US)) == 0)) {
			returndata.urladd = origurl;
			returndata.from = "��Ѷ��Ƶ";
			return returndata;
		}
		
		/* ������У�� */
		if (url.startsWith(WASU_START)) {
			returndata.urladd = origurl;
			returndata.from = "����TV";
			return returndata;
		}
		if (url.startsWith(WASU_NOWWW_START)) {
			returndata.urladd = origurl.replace("//wasu", "//www.wasu");
			returndata.from = "����TV";
			return returndata;
		}

		/* ������У�� */
		if (url.startsWith(NETEASE_START) || url.startsWith(NETEASEGAME_START) ) {
			returndata.urladd = origurl;
			returndata.from = "����";
			returndata.needotherhandle=true;
			returndata.handlesite="netease";
			return returndata;
		}
		/* ������У�� */
		if (url.startsWith(NETEASEOPEN_START)) {
			returndata.urladd = origurl;
			returndata.from = "���׹�����";
			returndata.needotherhandle=true;
			returndata.handlesite="netease";
			return returndata;
		} 

		/* PPS��У�� */
		if (url.startsWith(PPS_START)) {//
			returndata.urladd = origurl;
			returndata.from = "PPS.tv";
			returndata.needotherhandle=true;//�����ȷ���Ƿ�ֱ�Ӷ�
			returndata.handlesite="pps";
			return returndata;
		}
		if(url.startsWith(PPSSWF_START)){
			String id = StringUtil.getStringBetween(url, 0,
					"sid/", "/").result;
			if(StringUtil.isEmpty(id)){
				returndata.urladd = origurl;
				returndata.from = "PPS.tv";
				return returndata;
			}else{
				if(id.length()<6){
					returndata.urladd = origurl;
					returndata.from = "PPS.tv";
					return returndata;
				}else{
					String newurl = "http://v.pps.tv/play_"+id.substring(0, 6)+".html";
					returndata.urladd = newurl;
					returndata.from = "PPS.tv";
					returndata.needotherhandle=true;//�����ȷ���Ƿ�ֱ�Ӷ�
					returndata.handlesite="pps";
					return returndata;
				}
			}
		}

		/* PPS��У�� */
		if (url.startsWith(YINYUETAI_START)) {//
			returndata.urladd = origurl;
			returndata.from = "����̨";
			return returndata;
		}

		/* ��������У�� */
		if (url.startsWith(IQIYI_START)||url.startsWith(IQIYINOWWW_START) || url.startsWith(IQIYI_SWF_START)
				||url.startsWith(IQIYI_SWF2_START) || url.startsWith(IQIYI_SWF2_NOWWW_START)) {// IQIYI
			returndata.urladd = origurl;
			returndata.from = "������";
			return returndata;
		}
		/* ��������У�� */
		if ((url.startsWith(IQIYI_QPLAY_START)||url.startsWith(IQIYI_QPLAY_NOWWW_START)) && url.indexOf("tvid=")>0 &&url.indexOf("vid=")>0 ) {// IQIYI
			returndata.urladd = origurl;
			returndata.from = "������";
			return returndata;
		}
		
		/* CNTV��У�� */
		if (url.startsWith(CNTV_START)) {// CNTV
			returndata.urladd = origurl;
			returndata.from = "CNTV";
			return returndata;
		}
		/* �������У�� */
		if (url.startsWith(IFENGVIDEO_START) && StrTotalCount(url, "/") > 4) {// SINASWF
			returndata.urladd = origurl;
			returndata.from = "�����";
			return returndata;
		}

		/* BILIBILI��У�� */
		if (url.startsWith(BILIBILI_START)
				|| url.startsWith(BILIBILINOWWW_START)
				|| url.startsWith(BILIBILI2_START)
				|| url.startsWith(BILIBILICOM_START)
				|| url.startsWith(BILIBILICOMNOWWW_START)) {// ������,BILIBILI����ӿڶ�ȡֱ�ӽ�ȡ����Ƶ��ַ\
			returndata.urladd = origurl;
			returndata.from = "BiliBili";
			returndata.needotherhandle=true;
			returndata.handlesite="bilibiliaid";
			return returndata;
		}
		if( url.startsWith(BILIBILI_SHAREACGTV_START)){
			String id = StringUtil.getStringBetween(origurl, 0, "/av",
					"/").result;
			returndata.urladd = "http://www.bilibili.com/video/av" + id + "/";
			returndata.from = "BiliBili";
			returndata.needotherhandle=true;
			returndata.handlesite="bilibiliaid";
			return returndata;
		}
		if (url.startsWith(BILIBILI_SHAREACGTV_FLASH_START)) {// SHARE.ACG.TV
			String id = StringUtil.getStringBetween(origurl, 0, "aid=",
					BILIBILI_SHAREACGTV_FLASH_END).result;
			returndata.urladd = "http://www.bilibili.com/video/av" + id + "/";
			returndata.from = "BiliBili";
			returndata.needotherhandle=true;
			returndata.handlesite="bilibiliaid";
			return returndata;
		}
		if (url.startsWith(BILIBILI_HDSLB_FLASH_START)) {// SHARE.ACG.TV
			String id = StringUtil.getStringBetween(origurl, 0, "aid=",
					BILIBILI_HDSLB_FLASH_END).result;
			returndata.urladd = "http://www.bilibili.com/video/av" + id + "/";
			returndata.from = "BiliBili";
			returndata.needotherhandle=true;
			returndata.handlesite="bilibiliaid";
			return returndata;
		}
		if (url.startsWith(BILIBILI_MACGTV_START)) {// M.ACG.TV
			String id = StringUtil.getStringBetween(origurl, 0,
					BILIBILI_MACGTV_START, BILIBILI_MACGTV_END).result;
			returndata.urladd = "http://www.bilibili.com/video/av" + id + "/";
			returndata.from = "BiliBili";
			returndata.needotherhandle=true;
			returndata.handlesite="bilibiliaid";
			return returndata;
		}
		if (url.startsWith(BILIBILI_SUPERLINK)) {// BILI SUPERLINK
			String id = StringUtil.getStringBetween(origurl, 0,
					BILIBILI_SUPERLINK, "/").result;
			returndata.urladd = "http://www.bilibili.com/video/av" + id + "/";
			returndata.from = "BiliBili";
			returndata.needotherhandle=true;
			returndata.handlesite="bilibiliaid";
			return returndata;
		}
		
		
		String youtubeid = null;
		/* ������ʱ��Ҫ���д��� */
		if (url.startsWith(YOUTUBE_WITH)) {// �Ȼ�ȡ��Ƶid,��ȡyoutube�����ݽӿ�,�����ݷָ�,ת��,��ȡ��ͬ�����ȵ�ַ
			youtubeid = StringUtil.getStringBetween(origurl, 0, YOUTUBE_WITH,
					YOUTUBE_END).result;
		} else if (url.startsWith(YOUTUBENOWWW_WITH)) {// �Ȼ�ȡ��Ƶid,��ȡyoutube�����ݽӿ�,�����ݷָ�,ת��,��ȡ��ͬ�����ȵ�ַ
			youtubeid = StringUtil.getStringBetween(origurl, 0,
					YOUTUBENOWWW_WITH, YOUTUBE_END).result;
		} else if (url.startsWith(YOUTUBESHARE_START)) {// �Ȼ�ȡ��Ƶid,��ȡyoutube�����ݽӿ�,�����ݷָ�,ת��,��ȡ��ͬ�����ȵ�ַ
			youtubeid = StringUtil.getStringBetween(origurl, 0,
					YOUTUBESHARE_START, YOUTUBE_END).result;
			
		} else if (url.startsWith(YOUTUBESHAREEMBED_START)) {// �Ȼ�ȡ��Ƶid,��ȡyoutube�����ݽӿ�,�����ݷָ�,ת��,��ȡ��ͬ�����ȵ�ַ
			youtubeid = StringUtil.getStringBetween(origurl, 0,
					YOUTUBESHAREEMBED_START, YOUTUBE_END).result;
			
		} else if (url.startsWith(YOUTUBESHAREEMBEDNOWWW_START)) {// �Ȼ�ȡ��Ƶid,��ȡyoutube�����ݽӿ�,�����ݷָ�,ת��,��ȡ��ͬ�����ȵ�ַ
			youtubeid = StringUtil.getStringBetween(origurl, 0,
					YOUTUBESHAREEMBEDNOWWW_START, YOUTUBE_END).result;
			
		} else if (url.startsWith(YOUTUBESHAREEMBEDNOCOOKIE_START)) {// �Ȼ�ȡ��Ƶid,��ȡyoutube�����ݽӿ�,�����ݷָ�,ת��,��ȡ��ͬ�����ȵ�ַ
			youtubeid = StringUtil.getStringBetween(origurl, 0,
					YOUTUBESHAREEMBEDNOCOOKIE_START, YOUTUBE_END).result;
		} else if (url.startsWith(YOUTUBESHAREEMBEDNOCOOKIENOWWW_START)) {// �Ȼ�ȡ��Ƶid,��ȡyoutube�����ݽӿ�,�����ݷָ�,ת��,��ȡ��ͬ�����ȵ�ַ
			youtubeid = StringUtil.getStringBetween(origurl, 0,
					YOUTUBESHAREEMBEDNOCOOKIENOWWW_START, YOUTUBE_END).result;
		} else if (url.startsWith(YOUTUBESHAREEMBEDOLD_START)) {// �Ȼ�ȡ��Ƶid,��ȡyoutube�����ݽӿ�,�����ݷָ�,ת��,��ȡ��ͬ�����ȵ�ַ
			youtubeid = StringUtil.getStringBetween(origurl, 0,
					YOUTUBESHAREEMBEDOLD_START, YOUTUBE_END).result;
		} else if (url.startsWith(YOUTUBESHAREEMBEDNOWWWOLD_START)) {// �Ȼ�ȡ��Ƶid,��ȡyoutube�����ݽӿ�,�����ݷָ�,ת��,��ȡ��ͬ�����ȵ�ַ
			youtubeid = StringUtil.getStringBetween(origurl, 0,
					YOUTUBESHAREEMBEDNOWWWOLD_START, YOUTUBE_END).result;
		} else if (url.startsWith(YOUTUBESHAREEMBEDNOCOOKIEOLD_START)) {// �Ȼ�ȡ��Ƶid,��ȡyoutube�����ݽӿ�,�����ݷָ�,ת��,��ȡ��ͬ�����ȵ�ַ
			youtubeid = StringUtil.getStringBetween(origurl, 0,
					YOUTUBESHAREEMBEDNOCOOKIEOLD_START, YOUTUBE_END).result;
		} else if (url.startsWith(YOUTUBESHAREEMBEDNOCOOKIENOWWWOLD_START)) {// �Ȼ�ȡ��Ƶid,��ȡyoutube�����ݽӿ�,�����ݷָ�,ת��,��ȡ��ͬ�����ȵ�ַ
			youtubeid = StringUtil.getStringBetween(origurl, 0,
					YOUTUBESHAREEMBEDNOCOOKIENOWWWOLD_START, YOUTUBE_END).result;
		}
		if(!StringUtil.isEmpty(youtubeid)){
			returndata.urladd = "https://www.youtube.com/get_video_info?video_id="+youtubeid;
			returndata.from = "YouTube";
			returndata.needotherhandle=true;//��Ҫֱ�Ӷ�
			returndata.handlesite="youtube";
			return returndata;
		}//TASKOK

		if (url.startsWith(ACFUN_START) || url.startsWith(ACFUNTV_START)) {// ������,ACFUN����ӿڻ������ƵԴ��ַ
			String id = origurl;
			returndata.urladd = id;
			returndata.from = "AcFun";
			returndata.needotherhandle=true;//��Ҫֱ�Ӷ�
			returndata.handlesite="acfun";
			return returndata;
		}
		if (url.startsWith(ACFUNNOWWW_START)||url.startsWith(ACFUNTVNOWWW_START)) {// ������,ACFUN����ӿڻ������ƵԴ��ַ
			String id = origurl.replace("//ac", "//www.ac");
			returndata.urladd = id;
			returndata.from = "AcFun";
			returndata.needotherhandle=true;//��Ҫֱ�Ӷ�
			returndata.handlesite="acfun";
			return returndata;
		}
		if (url.startsWith(ACFUNSWF_START.toLowerCase(Locale.US)) || url.startsWith(ACFUNTVSWF_START.toLowerCase(Locale.US))) {// ������,ACFUN����ӿڻ������ƵԴ��ַ
			String id = StringUtil.getStringBetween(origurl, 0, "url=", "&").result;
			returndata.urladd = id;
			returndata.from = "AcFun";
			returndata.needotherhandle=true;//��Ҫֱ�Ӷ�
			returndata.handlesite="acfun";
			return returndata;
		}
		
		String sohum3u8="";
		if (url.startsWith(MYSOHU_START)) {// �Ѻ�,����ֱ����ID������
			String id = StringUtil.getStringBetween(origurl, 0, MYSOHU_START,
					MYSOHU_END).result;
			id = id.substring(id.lastIndexOf("/") + 1);
			sohum3u8 = "http://my.tv.sohu.com/ipad/" + id + ".m3u8";
		}else if (url.startsWith(MYSOHU2_START)) {// �Ѻ�,����ֱ����ID������
			String id = StringUtil.getStringBetween(origurl, 0, MYSOHU2_START,
					MYSOHU2_END).result;
			id = id.substring(id.lastIndexOf("/") + 1);
			sohum3u8 = "http://my.tv.sohu.com/ipad/" + id + ".m3u8";
		}else if (url.startsWith(MYSOHUSWF_START)) {// �Ѻ�,����ֱ����ID������
			String id = StringUtil.getStringBetween(origurl, 0, "id=", "&").result;
			sohum3u8 = "http://my.tv.sohu.com/ipad/" + id + ".m3u8";
		}else if(url.startsWith(SOHUNEWLINK_START)){
			String id = StringUtil.getStringBetween(origurl, 0, "#", "_").result;
			sohum3u8 = "http://my.tv.sohu.com/ipad/" + id + ".m3u8";
		}else if (url.startsWith(SOHUSWF_START)) {// �Ѻ�,����ֱ����ID������
			String id = StringUtil.getStringBetween(origurl, 0, SOHUSWF_START,
					SOHUSWF_END).result;
			sohum3u8 = "http://hot.vrs.sohu.com/ipad" + id + ".m3u8";
		}
		if(!StringUtil.isEmpty(sohum3u8)){
			returndata.urladd = sohum3u8;
			returndata.from = "�Ѻ���Ƶ";
			returndata.needotherhandle=true;//��Ҫֱ�Ӷ�
			returndata.origurl=origurl;
			returndata.handlesite="sohuneedtitle";
			return returndata;
		}
		if (url.startsWith(SOHU_START)) {// �Ѻ�,����ֱ����ID������
			returndata.urladd = origurl;
			returndata.from = "�Ѻ���Ƶ";
			returndata.needotherhandle=true;//��Ҫֱ�Ӷ�
			returndata.handlesite="sohuneedhandle";
			return returndata;
		}
		
		if (url.startsWith(YOUXIA_START)) {
			returndata.urladd = origurl;
			returndata.from = "������";
			returndata.needotherhandle=true;//��Ҫֱ�Ӷ�
			returndata.handlesite="youxia";
			return returndata;
		}

		if (url.startsWith(BILIBILICID_START)) {// ������,BILIBILI��CID��VID�Ľӿڲ�һ��
			String id = StringUtil.getStringBetween(origurl, 0, "cid=",
					BILIBILICID_END).result;
			returndata.urladd = "http://www.bilibili.tv/m/html5?cid="+id;
			returndata.from = "BiliBili";
			returndata.needotherhandle=true;//��Ҫֱ�Ӷ�
			returndata.handlesite="bilibili";
			return returndata;
		}//TASKOK


		if (url.startsWith(SINA_START) && StrTotalCount(url, "/") > 4) {// SINASWF
			returndata.urladd = origurl;
			returndata.from = "������Ƶ";
			return returndata;
		}
		if (url.startsWith(SINATV_START)) {// SINASWF
			returndata.urladd = origurl;
			returndata.from = "������Ƶ";
			return returndata;
		}
		if (url.startsWith(SINAOPEN_START)) {// SINASWF
			returndata.urladd = origurl;
			returndata.from = "���˹�����";
			return returndata;
		}

		if (url.startsWith(M1905_START)) {//JSON��һ��
			returndata.urladd = origurl;
			returndata.from = "M1905";
			returndata.needotherhandle=true;//��Ҫֱ�Ӷ�
			returndata.handlesite="m1905";
			return returndata;
		}
		if (url.startsWith(M1905NOWWW_START)) {//JSON��һ��
			returndata.urladd = origurl.replace("//19", "//www.19");
			returndata.from = "M1905";
			returndata.needotherhandle=true;//��Ҫֱ�Ӷ�
			returndata.handlesite="m1905";
			return returndata;
		}

		if (url.startsWith(TED_TALK_START)) {//
			returndata.urladd = origurl;
			returndata.from = "TED";
			returndata.needotherhandle=true;//��Ҫֱ�Ӷ�
			returndata.handlesite="ted";
			return returndata;
		}
		if (url.startsWith(TED_TALK_NOWWW_START)) {//
			returndata.urladd = origurl.replace("//te", "//www.te");
			returndata.from = "TED";
			returndata.needotherhandle=true;//��Ҫֱ�Ӷ�
			returndata.handlesite="ted";
			return returndata;
		}
		
		returndata.urladd = origurl;
		returndata.from = "";
		return returndata;
	}

	private static int StrTotalCount(String str, String key) {
		int count = 0;
		int index = 0;
		while ((index = str.indexOf(key, index)) != -1) {
			index = index + key.length();
			count++;
		}
		return count;
	}
}
