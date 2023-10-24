package pl.zabrze.zs10.koszykowka;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PunktyViewModel extends ViewModel {
    private MutableLiveData<Integer> punkty;

    public MutableLiveData<Integer> getPunkty() {
        if(punkty == null){
            punkty = new MutableLiveData<>();
            punkty.setValue(0);
        }
        return punkty;
    }

    public void setPunkty(int p) {
        if(punkty.getValue() != null){
            punkty.setValue(p);
        }
    }
    public void dodajPunkty(int i){
        if(punkty.getValue() != null){
            punkty.setValue(punkty.getValue()+i);
        }
    }
}
