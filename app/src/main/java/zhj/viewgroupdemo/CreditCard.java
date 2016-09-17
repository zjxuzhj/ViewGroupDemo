package zhj.viewgroupdemo;

/**
 * Created by HongJay on 2016/9/13.
 */
public class CreditCard {


    public String getEdittext1() {
        return edittext1;
    }

    public void setEdittext1(String edittext1) {
        this.edittext1 = edittext1;
    }

    public String getEdittext2() {
        return edittext2;
    }

    public void setEdittext2(String edittext2) {
        this.edittext2 = edittext2;
    }

    private String edittext1;
    private String edittext2;
    private int type;
    CreditCard(String edittext1,String edittext2,int type){
        this.edittext1=edittext1;
        this.edittext2=edittext2;
        this.type=type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }


}
