package zhj.viewgroupdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by HongJay on 2016/9/13.
 */
public class Madapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_EDIT = 0;//编辑框
    private static final int TYPE_BUTTON = 1;//按钮
    private static final int TYPE_SPINNER = 2;//下拉列表
    private ArrayList<RecycleViewItemData> dataList;//数据集合


    public Madapter(ArrayList<RecycleViewItemData> dataList) {
        this.dataList = dataList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //如果viewType是编辑框类型,则创建EditViewHolder型viewholder
        if (viewType == TYPE_EDIT) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_creditcard_edit, parent, false);
            EditViewHolder viewHolder = new EditViewHolder(view);
            return viewHolder;
        }
        //如果viewType是按钮类型,则创建ButtonViewHolder型viewholder
        if (viewType == TYPE_BUTTON) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_creditcard_button, parent, false);
            ButtonViewHolder viewHolder = new ButtonViewHolder(view);
            return viewHolder;
        }
        //如果viewType是下拉列表类型,则创建SpinnerHolder型viewholder
        if (viewType == TYPE_SPINNER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_creditcard_spinner, parent, false);
            SpinnerHolder viewHolder = new SpinnerHolder(view);
            return viewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //如果holder是EditViewHolder的实例
        if (holder instanceof EditViewHolder) {
            EditItem mEditItem = (EditItem) dataList.get(position).getT();
            if (position == 0) {
                ((EditViewHolder) holder).mTextView1.setText("* Holder Name");
                ((EditViewHolder) holder).mTextView2.setText("* Card Number");
            } else if (position == 3) {
                ((EditViewHolder) holder).mTextView1.setText("          * Street ");
                ((EditViewHolder) holder).mTextView2.setText("           * City  ");

            } else if (position == 5) {
                ((EditViewHolder) holder).mTextView1.setText("                   Or ");
                ((EditViewHolder) holder).mTextView2.setText("           * Zipcode  ");
            }
            ((EditViewHolder) holder).mEditText1.setText(mEditItem.getText1());
            ((EditViewHolder) holder).mEditText2.setText(mEditItem.getText2());

        }
        //如果holder是ButtonViewHolder的实例
        if (holder instanceof ButtonViewHolder) {
            //从数据集合中取出该项
            ButtonItem mButtonItem = (ButtonItem) dataList.get(position).getT();
            //设置选中的按钮
            switch (mButtonItem.getPosition()) {
                case 0:
                    ((ButtonViewHolder) holder).mRadioButton.setChecked(true);
                    break;
                case 1:
                    ((ButtonViewHolder) holder).mRadioButton2.setChecked(true);
                    break;
                case 2:
                    ((ButtonViewHolder) holder).mRadioButton3.setChecked(true);
//                    ((EditViewHolder) holder).mEditText1.setFilters(new InputFilter[]{new InputFilter.LengthFilter(10)});
                    break;
            }
        }
        //如果holder是SpinnerHolder的实例
        if (holder instanceof SpinnerHolder) {
        }

    }

    @Override
    public int getItemViewType(int position) {
        if (0 == dataList.get(position).getDataType()) {
            return TYPE_EDIT;// 编辑框
        } else if (1 == dataList.get(position).getDataType()) {
            return TYPE_BUTTON;// 按钮
        } else if (2 == dataList.get(position).getDataType()) {
            return TYPE_SPINNER;//下拉列表
        } else {
            return 0;
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public class EditViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextView1;
        public TextView mTextView2;
        public EditText mEditText1;
        public EditText mEditText2;

        public EditViewHolder(View itemView) {
            super(itemView);
            mTextView1 = (TextView) itemView.findViewById(R.id.text1);
            mTextView2 = (TextView) itemView.findViewById(R.id.text2);
            mEditText1 = (EditText) itemView.findViewById(R.id.editText1);
            mEditText2 = (EditText) itemView.findViewById(R.id.editText2);
        }
    }

    public class ButtonViewHolder extends RecyclerView.ViewHolder {
        public RadioButton mRadioButton;
        public RadioButton mRadioButton2;
        public RadioButton mRadioButton3;

        public ButtonViewHolder(View itemView) {
            super(itemView);
            mRadioButton = (RadioButton) itemView.findViewById(R.id.radioButton);
            mRadioButton2 = (RadioButton) itemView.findViewById(R.id.radioButton2);
            mRadioButton3 = (RadioButton) itemView.findViewById(R.id.radioButton3);
        }
    }

    public class SpinnerHolder extends RecyclerView.ViewHolder {
        public SpinnerHolder(View itemView) {
            super(itemView);
        }
    }
}
