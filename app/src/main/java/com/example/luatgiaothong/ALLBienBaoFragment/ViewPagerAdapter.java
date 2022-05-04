package com.example.luatgiaothong.ALLBienBaoFragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:{
                return new fragment_bien_bao_cam();
            }
            case 1:{
                return new fragment_bien_hieu_lenh();
            }
            case 2:{
                return new fragment_bien_chi_dan();
            }
            case 3:{
                return new fragment_bien_bao_nguy_hiem_canh_bao();
            }
            case 4:{
                return new fragment_bien_phu();
            }
            default:{
                return new fragment_bien_bao_cam();
            }

        }
    }

    @Override
    public int getCount() {
        return 5;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String xau = "";

        switch (position){
            case 0:{
                xau = "Biển báo cấm";
                break;
            }
            case 1:{
                xau = "Biển hiệu lệnh";
                break;
            }

            case 2:{
                xau = "Biển chỉ dẫn";
                break;
            }

            case 3:{
                xau = "Biển báo nguy hiểm và cảnh báo";
                break;
            }

            case 4:{
                xau = "Biển phụ";
                break;
            }

        }

        return xau;
    }
}
