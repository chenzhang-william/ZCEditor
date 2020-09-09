package com.zc.editor.base.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.zc.editor.R;
import com.zc.editor.base.beans.BaseRecyclerBean;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CommonViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.btn_item_common)
    Button mBtnItemCommon;
    private Activity mActivity;
    private BaseRecyclerBean mClassBean;
    public CommonViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void setDataSource(BaseRecyclerBean classBean,Activity activity){
        mActivity = activity;
        mClassBean = classBean;
        mBtnItemCommon.setText(classBean.getName());
        mBtnItemCommon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.startActivity(new Intent(mActivity, mClassBean.getClazz()));
            }
        });
    }
}
