package com.example.moroapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;
import org.json.JSONObject;

public class Activity_Payment extends AppCompatActivity{
//    private RecyclerView.Adapter adapter;
//    private RecyclerView recyclerViewList;
//    private ManagementCard managementCard;
    RadioButton radRazorpay, radMomo;
    RadioGroup radPaymentMethod;
    TextView txtPricePack,txtTotalPayment,txtTypeService, txtTypePack, txtDayPack;
    Button btnPay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
//        managementCard = new ManagementCard(this);
        linkViews();
        addEvents();
//        initList();
        calculateFee ();


        Checkout.preload(Activity_Payment.this);

    }

    private void addEvents() {
        radPaymentMethod.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int i) {
                switch (i){
                    case R.id.rad_Momo:
                        //if choose btnPay , intent to activity payument success
//                        btnPay.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                Intent intent = new Intent(Activity_Payment.this, Activity_Payment_Success.class);
//                                startActivity(intent);
//                            }
//                        });
                          break;

                    case R.id.rad_razorpay:
                        startPayment(txtTotalPayment.getText().toString());
                        break;
            }
        }
        });
        radPaymentMethod.check(R.id.rad_Momo);

    }

    private void linkViews() {

        txtTotalPayment = findViewById(R.id.txt_total_payment);
        txtTypeService = findViewById(R.id.txt_type_service);
        txtDayPack = findViewById(R.id.txt_day_pack);
        txtTypePack = findViewById(R.id.txt_type_pack);
        radMomo = findViewById(R.id.rad_Momo);
        radRazorpay = findViewById(R.id.rad_razorpay);
        radPaymentMethod = findViewById(R.id.rad_PaymentMethod);
        btnPay = findViewById(R.id.btn_pay);
//        Crisp.configure(getApplicationContext(), "1b4d03b2-db60-4da9-b658-bcf6eceac6f1");
//        btnPay.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent crispIntent = new Intent(Activity_Payment.this, Activity_Payment_Success.class);
//                startActivity(crispIntent);
//            }
//        });
        btnPay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity_Payment.this, Activity_Payment_Success.class);
                startActivity(intent);
            }
        });
    }
//    private void initList() {
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        adapter = new CartListAdapter(this, managementCard.getListCard(), new ChangeNumberItemListener(){
//            @Override
//            public void changed() {
//                calculateCart();
//
//            }
//        });
//        recyclerViewList.setLayoutManager(linearLayoutManager);
//        recyclerViewList.setAdapter(adapter);
//
//    }
    private void calculateFee (){
//        double delivery = 10;
        TextView total;
        total = findViewById(R.id.txt_price_pack);
//        double total = Math.round(managementCard.getTotalFee()+ delivery);
//        txtTotalFee.setText(managementCard.getTotalFee() + "VND");
//        txtDeliveryFee.setText(delivery + "VND");
//       txt_Price txtTotalPayment.setText(total+ "VND");
        txtTotalPayment.setText(total.getText().toString());

    }
    public void startPayment(String Amount) {
        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_test_Gwu7096t8khiDh");
        try{
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", "MORO");
            jsonObject.put("description", "Giao dịch nhanh chóng với RazorPay");
            //   jsonObject.put("image", "");
            jsonObject.put("theme.color", "#993e22");
            jsonObject.put("currency", "VND");
            jsonObject.put("amount", Amount);

            JSONObject retryObj=new JSONObject();
            retryObj.put("enabled", true);
            retryObj.put("max_count",4);

            jsonObject.put("retry", retryObj);

            checkout.open(Activity_Payment.this, retryObj);

        }catch (Exception e){
            Toast.makeText(Activity_Payment.this, "Có gì đó không ổn", Toast.LENGTH_SHORT).show();
        }

    }


    public void onPaymentSuccess(String s) {
        Toast.makeText(Activity_Payment.this, s, Toast.LENGTH_SHORT).show();
    }


    public void onPaymentError(int i, String s) {
        Toast.makeText(Activity_Payment.this, "Error: "+ s, Toast.LENGTH_SHORT).show();
    }

}