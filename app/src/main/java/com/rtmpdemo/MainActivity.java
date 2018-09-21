package com.rtmpdemo;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import java.util.ArrayList;

import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.VideoView;

public class MainActivity extends Activity {

    private static final String TAG = "MainActivity";
    private String[] mPaths = {"rtmp://live1.baihuwang.com:1935/live/zh","rtmp://live1.baihuwang.com:1935/live/bh",
                    "rtmp://live1.baihuwang.com:1935/live/kj","rtmp://live1.baihuwang.com:1935/live/zh"};
    //private HashMap<String, String> options;
    private VideoView mVideoView,mVideoView2,mVideoView3,mVideoView4;

    private ArrayList<VideoView> mList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!LibsChecker.checkVitamioLibs(this))
            return;
        setContentView(R.layout.activity_main);
        mVideoView = (VideoView) findViewById(R.id.vitamio_videoView);
        mVideoView2 = (VideoView) findViewById(R.id.vitamio_videoView2);
        mVideoView3 = (VideoView) findViewById(R.id.vitamio_videoView3);
        mVideoView4 = (VideoView) findViewById(R.id.vitamio_videoView4);

        mList.add(mVideoView);
//        mList.add(mVideoView2);
//        mList.add(mVideoView3);
//        mList.add(mVideoView4);

        //rtsp://184.72.239.149/vod/mp4://BigBuckBunny_175k.mov
        //rtmp://live1.baihuwang.com:1935/live/zh,大庆综合
        //http://live1.av.jiaodong.net/channels/yttv/xnpd_yt1/flv:500k,烟台新闻
        //http://live1.av.jiaodong.net/channels/yttv/xnpd_yt2/flv:500k,烟台经济
        //rtmp://live1.baihuwang.com:1935/live/bh,大庆百湖
        //rtmp://live1.baihuwang.com:1935/live/kj,大庆科教
//        path = "rtmp://live1.baihuwang.com:1935/live/zh";//这里写你自己的拉流地址
//        for (int i = 0; i < mList.size(); i++) {
//            final VideoView videoView = mList.get(i);
////            videoView.setVideoPath(mPaths[0]);
//            videoView.setVideoURI(Uri.parse(mPaths[0]));
////            videoView.setMediaController(new MediaController(this));
////            videoView.setVideoLayout();
//            videoView.requestFocus();
//
//            videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
//                @Override
//                public void onPrepared(MediaPlayer mediaPlayer) {
//                    mediaPlayer.setPlaybackSpeed(1.0f);
//                    mediaPlayer.start();
//                    videoView.setVideoLayout(VideoView.VIDEO_LAYOUT_ORIGIN,0);
//                }
//            });
//        }

        mVideoView.setVideoURI(Uri.parse(mPaths[0]));
        mVideoView.requestFocus();
        mVideoView.setOnPreparedListener(new PreparedListener());

        mVideoView2.setVideoURI(Uri.parse(mPaths[1]));
        mVideoView2.requestFocus();
        mVideoView2.setOnPreparedListener(new PreparedListener2());
    }

    class PreparedListener implements MediaPlayer.OnPreparedListener{

        @Override
        public void onPrepared(MediaPlayer mp) {
            mp.setPlaybackSpeed(1.0f);
            mp.start();
            mVideoView.setVideoLayout(VideoView.VIDEO_LAYOUT_ORIGIN,0.5f);
        }
    }

    class PreparedListener2 implements MediaPlayer.OnPreparedListener{

        @Override
        public void onPrepared(MediaPlayer mp) {
            mp.setPlaybackSpeed(1.0f);
            mp.start();
            mVideoView2.setVideoLayout(VideoView.VIDEO_LAYOUT_ORIGIN,0.5f);
        }
    }
}
