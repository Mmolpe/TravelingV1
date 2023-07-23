package es.travelworld.travelingv1;


import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class User extends BaseObservable {
    private String name;
    private String subname;

    private boolean btnEnable = false;

    @Bindable
    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        if (!subname.equals(this.subname)) {
            this.subname = subname;
            changeNameSubname();
            notifyPropertyChanged(BR.subname);
        }
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.equals(this.name)) {
            this.name = name;
            changeNameSubname();
            notifyPropertyChanged(BR.name);
        }
    }

    @Bindable
    public boolean isBtnEnable() {
        return btnEnable;
    }

    public void changeNameSubname() {
        if (name != null && subname != null) {
            if (!name.isEmpty() && !subname.isEmpty()) {
                btnEnable = true;
            } else {
                btnEnable = false;
            }

        } else {
            btnEnable = false;
        }
        notifyPropertyChanged(BR.btnEnable);

    }
}
