package vn.edu.ntu.nguyenvanhoan.NguyenVanHoan_59130788_SimpleWidget;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText Name;
    EditText Birth_Date;
    EditText other_Hobby;
    RadioGroup Sex;
    ArrayList<Integer> So_thich;
    Button Button_xac_nhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anh_Xa();
        Su_kien();
    }

    private void Anh_Xa() {
        Name = findViewById(R.id.Ten);
        Birth_Date = findViewById(R.id.ngay_sinh);
        other_Hobby = findViewById(R.id.so_thich_khac);
        Sex = findViewById(R.id.Gioi_Tinh);

        Button_xac_nhan = findViewById(R.id.xac_nhan);

        So_thich = new ArrayList<>();
        So_thich.add(R.id.xem_phim);
        So_thich.add(R.id.nghe_nhac);
        So_thich.add(R.id.Cafe);
        So_thich.add(R.id.o_nha);
        So_thich.add(R.id.nau_an);
    }

    private void Su_kien () {
        Button_xac_nhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alert();
            }
        });
    }

    private void alert() {
        String alertMessage;
        alertMessage = Name.getText().toString() + "\n" +
                "Ngày sinh: " + Birth_Date.getText().toString() + "\n" +
                "Giới tính: ";
        switch (Sex.getCheckedRadioButtonId()) {
            case R.id.nam:
                alertMessage += "Nam\n";
                break;
            case R.id.nu:
                alertMessage += "Nữ\n";
                break;
        }

        String hobbiesStr = "";
        ArrayList<CheckBox> temp = new ArrayList<>();
        int j = 0;
        for (Integer i : So_thich) {
            temp.add((CheckBox) findViewById(i));
            if (temp.get(j).isChecked()) {
                hobbiesStr += temp.get(j).getText().toString() + ", ";
            }
            j += 1;
        }
        hobbiesStr += other_Hobby.getText().toString();
        alertMessage += "Sở thích: ";
        if (hobbiesStr.isEmpty())
            alertMessage += "Không có";
        else
            alertMessage += hobbiesStr;

        Toast.makeText(getApplicationContext(), alertMessage.toString(), Toast.LENGTH_SHORT).show();
    }
}
