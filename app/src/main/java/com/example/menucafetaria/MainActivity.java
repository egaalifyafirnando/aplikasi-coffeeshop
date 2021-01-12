package com.example.menucafetaria;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.LayoutInflater;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"Burger", "Pizza", "Pancake", "Donut", "Coookies", "Coconut Pasta", "Ice Cream Pasta", "Ice Cream Topping", "Coffee Milk", "Coffee Robusta"};
    String mDescription[] = {"Rp. 25.000", "Rp. 35.000", "Rp. 19.000", "Rp. 8.000", "Rp. 9.000", "Rp. 8.000", "Rp. 10.000", "Rp. 12.000", "Rp. 9.000", "Rp. 8.000"};
    String detailDescription[] = {
            "Siapa sih yang gak kenal sama makanan ini... Yaappp, burger. Makanan ini menjadi menu favorit loh gais di Cafetaria, karena rasanya yang yahud dan ukurannya yang jumbo pastinya. Harganya juga murah kok gais cuma 25 ribu rupiah aja, buruan sikat sebelum kehabisan... hehehe \n \n " +
                    "Varian Burger yang tersedia: \n" +
                    "- Cheese Burger cuma Rp. 25.000 \n" +
                    "- BBQ Crispy Chicken cuma Rp. 29.000 \n" +
                    "- Burger Mushroom Swiss cuma Rp. 33.000 \n" +
                    "- Beef BBQ cuma Rp. 33.000 \n" +
                    "- Fish Fillet cuma Rp. 32.000 \n" +
                    "- Mozarella Beef cuma Rp. 35.000 \n",
            "Hayo siapa yang ga pengen nyobain makanan terlezat di Cafetaria..? hehehe Pizza disini di olah dengan resep pilihan sehingga menghasilkan rasa yang uenak dan gurih pastinya. Pizza ini di banderol mulai dari 35 ribu aja lohhh... Yuk buruan sikat sebelum kehabisan. \n \n" +
                    "Varian Pizza yang tersedia: \n" +
                    "- Pizza Original cuma Rp. 35.000 \n" +
                    "- Pepperoni cuma Rp. 44.000 \n" +
                    "- Meats with Cheesy Mayo cuma Rp. 50.000 \n" +
                    "- Tuna Melt cuma Rp. 49.000,00 \n" +
                    "- Mushroom with Pepperoni cuma Rp. 55.000 \n" +
                    "- Super Supreme cuma Rp. 60.000 \n",
            "Hayo siapa yang ga pengen nyobain menu terbaru di Cafetaria..? hehehe ini adalah Pancake dengan rasa yang gurih dan nikmat diolah dengan resep yang handal cocok untuk pengunjung yang bersantai disini. Pancake ini di banderol mulai dari 19 ribu aja lohhh... \n \n" +
                    "Varian Pancake yang tersedia disini: \n" +
                    "- Pancake Original cuma Rp. 19.000 \n" +
                    "- Pancake Fruit Mix cuma Rp. 25.000 \n" +
                    "- Pancake Cheesy cuma Rp. 22.000 \n" +
                    "- Pancake with Sausage cuma Rp. 35.000 \n" +
                    "- Pancake Corned Beef cuma Rp. 30.000 \n" +
                    "- Pancake Choco cuma Rp. 24.000 \n",
            "Donut timeeeee.... Hehehe donut di Cafetaria ini punya banyak varian rasa lohhhh... harganya juga murah cuma 8 ribuan aja gaissss. Jadi gak heran donut selalu jadi pilihan pengunjung di Cafetaria ini. Yuk buruan cobain varian varian terbarunya sebelum kehabisan gais xixixi... \n \n" +
                    "Varian Donut yang tersedia disini: \n" +
                    "- Donut Original cuma Rp. 8.000 \n" +
                    "- Donut Cheesy cuma Rp. 8.000 \n" +
                    "- Donut Chooco cuma Rp. 8.000 \n" +
                    "- Donut Mathca cuma Rp. 8.000 \n" +
                    "- Donut Caramel cuma Rp. 8.000 \n" +
                    "- Donut Vanilla cuma Rp. 8.000 \n",
            "Ada yang tau gak sama makanan ini...? Yapppp ini adalah Cookies. Cookies di Cafetaria ini rasanya renyah dan gurih looohhh.. Karena diolah dengan resep rahasia dari chef Cafetaria. Yuk buktikan kelezatannya hanya dengan harganya mulai dari 9 ribu aja loh !!!! \n \n" +
                    "Varian Cookies yang tersedia: \n" +
                    "- Cookies Original cuma Rp. 9.000 \n" +
                    "- Cookies Chocochips cuma Rp. 10.000 \n" +
                    "- Cookies Oreo cuma Rp. 13.000 \n" +
                    "- Cookies Caramel cuma Rp. 11.000 \n" +
                    "- Dark Original cuma Rp. 10.000 \n" +
                    "- Supreme Choco cuma Rp. 15.000 \n",
            "Siapa sih yang gak kenal sama makanan ini... Yaappp, Coconut Pasta. Makanan ini menjadi menu favorit loh gais di Cafetaria, karena rasanya yang manis dan seger pastinya. Harganya juga murah kok gais cuma 8 ribu rupiah aja, buruan sikat sebelum kehabisan... hehehe \n \n " +
                    "Varian Topping Coconut Pasta yang tersedia: \n" +
                    "- Coconut Chocolate Pasta cuma Rp. 8.000 \n" +
                    "- Coconut Pandan cuma Rp. 9.000 \n" +
                    "- Coconut Matcha cuma Rp. 12.000 \n" +
                    "- Coconut milk cuma Rp. 11.000 \n \n \n",
            "Hayo siapa yang ga pengen nyobain dessert terlezat di Cafetaria..? hehehe Ice Cream disini di olah dengan resep pilihan sehingga menghasilkan rasa yang uenak dan seger pastinya. Ice Cream ini di banderol mulai dari 10 ribu aja lohhh... Yuk buruan sikat sebelum kehabisan. \n \n" +
                    "Varian Cookies yang tersedia: \n" +
                    "- Ice Cream Original cuma Rp. 9.000 \n" +
                    "- Ice Cream Chocolate Swiss cuma Rp. 10.000 \n" +
                    "- Ice Cream Matcha Latte cuma Rp. 12.000 \n" +
                    "- Ice Cream Caramel cuma Rp. 10.000 \n" +
                    "- Ice Cream Hazelnut cuma Rp. 10.000 \n \n",
            "Hayo siapa yang ga pengen nyobain makanan terlezat di Cafetaria..? hehehe Ice Cream disini di olah dengan susu asli loh gais. Ice Cream ini di banderol mulai dari 12 ribu aja lohhh... Yuk buruan sikat sebelum kehabisan. xixiixi.. \n \n" +
                    "Varian Topping yang tersedia: \n" +
                    "- Chocochips cuma Rp. 3.000 \n" +
                    "- Oreo cuma Rp. 3.000 \n" +
                    "- Boba cuma Rp. 4.000 \n" +
                    "- Caramel cuma Rp. 2.000 \n" +
                    "- Matcha Latte cuma Rp. 4.000 \n \n \n ",
            "Coffee time... Gak klop rasanya jika ke Cafetaria tidak membeli item satu ini. kopi ini diolah dengan kualitas terbaik dan disuguhkan oleh barista professional. Anda juga dapat merequest bentuk gambar pada kopi yang anda pesan. Kopi ini menjadi pilihan favorit pengunjung Cafetaria ini. harganya cuma 9 ribu aja gaisss, yuk buruan sikattt ! \n \n \n \n \n \n \n \n ",
            "Coffee time... Gak klop rasanya jika ke Cafetaria tidak membeli item satu ini. kopi ini diolah dari biji kopi pilihan dengan kualitas terbaik dan disuguhkan oleh barista professional. kopi ini menjadi pilihan favorit pengunjung Cafetaria ini. harganya cuma 8 ribu aja gaisss, yuk buruan sikattt ! \n \n \n \n \n \n \n \n  "};
    int images[] = {R.drawable.burgerr, R.drawable.pizza, R.drawable.pancake, R.drawable.donut, R.drawable.cookies, R.drawable.coconutpasta, R.drawable.greentea, R.drawable.ice, R.drawable.kopi2, R.drawable.kopihitam};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = findViewById(R.id.listView);


        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(getApplicationContext(), AnotherActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putInt("image", images[0]);
                    intent.putExtras(bundle);

                    intent.putExtra("title", mTitle[0]);
                    intent.putExtra("description", detailDescription[0]);

                    intent.putExtra("position", ""+0);
                    startActivity(intent);

                }
                if (position == 1) {
                    Intent intent = new Intent(getApplicationContext(), AnotherActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putInt("image", images[1]);
                    intent.putExtras(bundle);

                    intent.putExtra("title", mTitle[1]);
                    intent.putExtra("description", detailDescription[1]);

                    intent.putExtra("position", ""+1);
                    startActivity(intent);
                }
                if (position == 2) {
                    Intent intent = new Intent(getApplicationContext(), AnotherActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putInt("image", images[2]);
                    intent.putExtras(bundle);

                    intent.putExtra("title", mTitle[2]);
                    intent.putExtra("description", detailDescription[2]);

                    intent.putExtra("position", ""+2);
                    startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(getApplicationContext(), AnotherActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putInt("image", images[3]);
                    intent.putExtras(bundle);

                    intent.putExtra("title", mTitle[3]);
                    intent.putExtra("description", detailDescription[3]);

                    intent.putExtra("position", ""+3);
                    startActivity(intent);
                }
                if (position == 4) {
                    Intent intent = new Intent(getApplicationContext(), AnotherActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putInt("image", images[4]);
                    intent.putExtras(bundle);

                    intent.putExtra("title", mTitle[4]);
                    intent.putExtra("description", detailDescription[4]);

                    intent.putExtra("position", ""+4);
                    startActivity(intent);
                }
                if (position == 5) {
                    Intent intent = new Intent(getApplicationContext(), AnotherActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putInt("image", images[5]);
                    intent.putExtras(bundle);

                    intent.putExtra("title", mTitle[5]);
                    intent.putExtra("description", detailDescription[5]);

                    intent.putExtra("position", ""+5);
                    startActivity(intent);
                }
                if (position == 6) {
                    Intent intent = new Intent(getApplicationContext(), AnotherActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putInt("image", images[6]);
                    intent.putExtras(bundle);

                    intent.putExtra("title", mTitle[6]);
                    intent.putExtra("description", detailDescription[6]);

                    intent.putExtra("position", ""+6);
                    startActivity(intent);
                }
                if (position == 7) {
                    Intent intent = new Intent(getApplicationContext(), AnotherActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putInt("image", images[7]);
                    intent.putExtras(bundle);

                    intent.putExtra("title", mTitle[7]);
                    intent.putExtra("description", detailDescription[7]);

                    intent.putExtra("position", ""+7);
                    startActivity(intent);
                }
                if (position == 8) {
                    Intent intent = new Intent(getApplicationContext(), AnotherActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putInt("image", images[8]);
                    intent.putExtras(bundle);

                    intent.putExtra("title", mTitle[8]);
                    intent.putExtra("description", detailDescription[8]);

                    intent.putExtra("position", ""+8);
                    startActivity(intent);
                }
                if (position == 9) {
                    Intent intent = new Intent(getApplicationContext(), AnotherActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putInt("image", images[9]);
                    intent.putExtras(bundle);

                    intent.putExtra("title", mTitle[9]);
                    intent.putExtra("description", detailDescription[9]);

                    intent.putExtra("position", ""+9);
                    startActivity(intent);
                }
            }
        });


    }

    class MyAdapter extends ArrayAdapter<String> {
        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter (Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.row_menu_item, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(context.LAYOUT_INFLATER_SERVICE);
            View row_menu_item = layoutInflater.inflate(R.layout.row_menu_item, parent, false);
            ImageView images = row_menu_item.findViewById(R.id.image);
            TextView myTitle = row_menu_item.findViewById(R.id.textView1);
            TextView myDescription = row_menu_item.findViewById(R.id.textView2);


            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);


            return row_menu_item;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_about) {

            Intent intent = new Intent(MainActivity.this, About.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}