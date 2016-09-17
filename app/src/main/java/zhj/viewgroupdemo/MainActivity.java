package zhj.viewgroupdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private ArrayList<RecycleViewItemData> dataList;
    @BindView(R.id.creditcard)
    RecyclerView mCreditcard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mCreditcard.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        dataList=new ArrayList<RecycleViewItemData>();
        dataList.add(new RecycleViewItemData(new EditItem("aaa","bbb"),0));
        dataList.add(new RecycleViewItemData(new ButtonItem(1),1));
        dataList.add(new RecycleViewItemData(new SpinnerItem("aaa","bbb"),2));
        dataList.add(new RecycleViewItemData(new EditItem("aaa","bbb"),0));
        dataList.add(new RecycleViewItemData(new SpinnerItem("aaa","bbb"),2));
        dataList.add(new RecycleViewItemData(new EditItem("aaa","bbb"),0));



        mCreditcard.setAdapter(new Madapter(dataList));
    }
}
