package com.jf.studentjfmusic;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.jf.studentjfmusic.adapter.PlayDetailsAdapter;
import com.jf.studentjfmusic.bean.NewPlayListResultsBean;
import com.jf.studentjfmusic.fragment.RoundFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * 播放详情
 */
public class PlayDetailsActivity extends AppCompatActivity {
    public static final String DETAILS_KEY = "details";


    @BindView(R.id.ll_actionbar)
    LinearLayout ll_actionbar;

    @BindView(R.id.iv)
    ImageView iv;


    @BindView(R.id.iv_bg)
    ImageView iv_bg;

    @BindView(R.id.iv_back)
    ImageView iv_back;

    @BindView(R.id.vp)
    ViewPager vp;

    ArrayList<RoundFragment> mRoundFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_details);
        ButterKnife.bind(this);
        NewPlayListResultsBean bean = getIntent().getParcelableExtra(DETAILS_KEY);



        iv.setColorFilter(R.color.color1);
        mRoundFragments = new ArrayList<>();
        mRoundFragments.add(new RoundFragment());
        mRoundFragments.add(new RoundFragment());
        mRoundFragments.add(new RoundFragment());
        mRoundFragments.add(new RoundFragment());
        mRoundFragments.add(new RoundFragment());
        mRoundFragments.add(new RoundFragment());
        mRoundFragments.add(new RoundFragment());
        PlayDetailsAdapter playDetailsAdapter = new PlayDetailsAdapter(getSupportFragmentManager(), mRoundFragments);
        vp.setAdapter(playDetailsAdapter);


        Glide.with(this)
                .load(bean.getAlbumPic().getUrl())
                //模糊图片, this   10 模糊度   5 将图片缩放到5倍后进行模糊
                .bitmapTransform(new BlurTransformation(this,10,3) {
                })
                .into(iv_bg);

    }

    @OnClick(R.id.iv_back)
    void back() {
        finish();
    }


}
