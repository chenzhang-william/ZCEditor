package com.zc.editor.base.viewHolder;

import android.view.View;


public interface IBaseRecyclerItemClickListener {
   void itemClickBack(View view, int position, boolean isLongClick, int comeFrom);

}
