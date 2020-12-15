package com.example.listadapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class BooksListsActivity extends AppCompatActivity {
    int[][] imagesIds = {
            { R.drawable.a1, R.string.title },
            { R.drawable.a2, R.string.title },
            { R.drawable.a3, R.string.title },
            { R.drawable.a4, R.string.title },
            { R.drawable.a5, R.string.title },
            { R.drawable.a6, R.string.title },
            { R.drawable.a7, R.string.title },
            { R.drawable.a8, R.string.title },
            { R.drawable.a9, R.string.title },
            { R.drawable.a10, R.string.title },
            { R.drawable.a11, R.string.title },
            { R.drawable.a12, R.string.title },
            { R.drawable.a13, R.string.title },
            { R.drawable.a14, R.string.title },
            { R.drawable.a15, R.string.title },
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_lists);

        ListView listView =findViewById(R.id.listView);
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1 , COUNTRIES);
//        listView.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
       MyAdapter arrayAdapter = new MyAdapter();
       arrayAdapter.setOnItemClickListener(new OnItemClickListener() {
           @Override
           public void OnItemClick(View view, int position) {
               switch (view.getId()){
                   case R.id.image_view_map:
                       Intent intent1 = new Intent(Intent.ACTION_VIEW , Uri.parse("geo:0,0?q=" + COUNTRIES[position]));
                       startActivity(intent1);
                       break;
                   case R.id.image_view_photo:
                       Intent intent2 = new Intent(BooksListsActivity.this , PhotoViewActivity.class);
                       intent2.putExtra("image_res" , imagesIds[position][0]);
                       startActivity(intent2);
                       break;
               }
           }
       });
        listView.setAdapter(arrayAdapter);

    }
    class MyAdapter extends BaseAdapter {
        private OnItemClickListener onItemClickListener;

        public MyAdapter(){

        }

        @Override
        public int getCount() {
            return imagesIds.length;
        }

        @Override
        public Object getItem(int position) {
            return imagesIds[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
              ViewHolder viewHolder;
            if (convertView == null){
                System.out.println("CREATE NEW VIEW");
                convertView =  LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout ,parent , false);
                viewHolder = new ViewHolder();
                viewHolder.imageView = convertView.findViewById(R.id.imageView);
                viewHolder.imageView.setAdjustViewBounds(true);
                viewHolder.mapImageView = convertView.findViewById(R.id.image_view_map);
                viewHolder.photoImageView = convertView.findViewById(R.id.image_view_photo);
                viewHolder.textView = convertView.findViewById(R.id.textView);
                View.OnClickListener onClickListener = new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = (int) v.getTag();
                        if (onItemClickListener != null) {
                            onItemClickListener.OnItemClick(v, position);
                        }
                    }
                };
                viewHolder.mapImageView.setOnClickListener(onClickListener);
                viewHolder.photoImageView.setOnClickListener(onClickListener);
                convertView.setTag(viewHolder);
            }else {
                System.out.println("REUSE OLD VIEW");
                viewHolder = (ViewHolder) convertView.getTag();
            }

            viewHolder.imageView.setImageResource(imagesIds[position][0]);
            viewHolder.textView.setText(COUNTRIES[position]);
            viewHolder.mapImageView.setTag(position);
            viewHolder.photoImageView.setTag(position);
            return convertView;
        }
        public void setOnItemClickListener(OnItemClickListener onItemClickListener){
         this.onItemClickListener = onItemClickListener;
        }

        class ViewHolder {
            ImageView imageView;
            TextView textView;
            ImageView mapImageView;
            ImageView photoImageView;
        }
    }

    static final String[] COUNTRIES = new String[] {
            "Afghanistan",
            "Albania",
            "Algeria",
            "American Samoa",
            "Andorra",
            "Angola",
            "Anguilla",
            "Antarctica",
            "Antigua and Barbuda",
            "Argentina",
            "Armenia",
            "Aruba",
            "Australia",
            "Austria",
            "Azerbaijan",
            "Bahamas (the)",
            "Bahrain",
            "Bangladesh",
            "Barbados",
            "Belarus",
            "Belgium",
            "Belize",
            "Benin",
            "Bermuda",
            "Bhutan",
            "Bolivia (Plurinational State of)",
            "Bonaire, Sint Eustatius and Saba",
            "Bosnia and Herzegovina",
            "Botswana",
            "Bouvet Island",
            "Brazil",
            "British Indian Ocean Territory (the)",
            "Brunei Darussalam",
            "Bulgaria",
            "Burkina Faso",
            "Burundi",
            "Cabo Verde",
            "Cambodia",
            "Cameroon",
            "Canada",
            "Cayman Islands (the)",
            "Central African Republic (the)",
            "Chad",
            "Chile",
            "China",
            "Christmas Island",
            "Cocos (Keeling) Islands (the)",
            "Colombia",
            "Comoros (the)",
            "Congo (the Democratic Republic of the)",
            "Congo (the)",
            "Cook Islands (the)",
            "Costa Rica",
            "Croatia",
            "Cuba",
            "Curaçao",
            "Cyprus",
            "Czechia",
            "Côte d'Ivoire",
            "Denmark",
            "Djibouti",
            "Dominica",
            "Dominican Republic (the)",
            "Ecuador",
            "Egypt",
            "El Salvador",
            "Equatorial Guinea",
            "Eritrea",
            "Estonia",
            "Eswatini",
            "Ethiopia",
            "Falkland Islands (the) [Malvinas]",
            "Faroe Islands (the)",
            "Fiji",
            "Finland",
            "France",
            "French Guiana",
            "French Polynesia",
            "French Southern Territories (the)",
            "Gabon",
            "Gambia (the)",
            "Georgia",
            "Germany",
            "Ghana",
            "Gibraltar",
            "Greece",
            "Greenland",
            "Grenada",
            "Guadeloupe",
            "Guam",
            "Guatemala",
            "Guernsey",
            "Guinea",
            "Guinea-Bissau",
            "Guyana",
            "Haiti",
            "Heard Island and McDonald Islands",
            "Holy See (the)",
            "Honduras",
            "Hong Kong",
            "Hungary",
            "Iceland",
            "India",
            "Indonesia",
            "Iran (Islamic Republic of)",
            "Iraq",
            "Ireland",
            "Isle of Man",
            "Israel",
            "Italy",
            "Jamaica",
            "Japan",
            "Jersey",
            "Jordan",
            "Kazakhstan",
            "Kenya",
            "Kiribati",
            "Korea (the Democratic People's Republic of)",
            "Korea (the Republic of)",
            "Kuwait",
            "Kyrgyzstan",
            "Lao People's Democratic Republic (the)",
            "Latvia",
            "Lebanon",
            "Lesotho",
            "Liberia",
            "Libya",
            "Liechtenstein",
            "Lithuania",
            "Luxembourg",
            "Macao",
            "Madagascar",
            "Malawi",
            "Malaysia",
            "Maldives",
            "Mali",
            "Malta",
            "Marshall Islands (the)",
            "Martinique",
            "Mauritania",
            "Mauritius",
            "Mayotte",
            "Mexico",
            "Micronesia (Federated States of)",
            "Moldova (the Republic of)",
            "Monaco",
            "Mongolia",
            "Montenegro",
            "Montserrat",
            "Morocco",
            "Mozambique",
            "Myanmar",
            "Namibia",
            "Nauru",
            "Nepal",
            "Netherlands (the)",
            "New Caledonia",
            "New Zealand",
            "Nicaragua",
            "Niger (the)",
            "Nigeria",
            "Niue",
            "Norfolk Island",
            "Northern Mariana Islands (the)",
            "Norway",
            "Oman",
            "Pakistan",
            "Palau",
            "Palestine, State of",
            "Panama",
            "Papua New Guinea",
            "Paraguay",
            "Peru",
            "Philippines (the)",
            "Pitcairn",
            "Poland",
            "Portugal",
            "Puerto Rico",
            "Qatar",
            "Republic of North Macedonia",
            "Romania",
            "Russian Federation (the)",
            "Rwanda",
            "Réunion",
            "Saint Barthélemy",
            "Saint Helena, Ascension and Tristan da Cunha",
            "Saint Kitts and Nevis",
            "Saint Lucia",
            "Saint Martin (French part)",
            "Saint Pierre and Miquelon",
            "Saint Vincent and the Grenadines",
            "Samoa",
            "San Marino",
            "Sao Tome and Principe",
            "Saudi Arabia",
            "Senegal",
            "Serbia",
            "Seychelles",
            "Sierra Leone",
            "Singapore",
            "Sint Maarten (Dutch part)",
            "Slovakia",
            "Slovenia",
            "Solomon Islands",
            "Somalia",
            "South Africa",
            "South Georgia and the South Sandwich Islands",
            "South Sudan",
            "Spain",
            "Sri Lanka",
            "Sudan (the)",
            "Suriname",
            "Svalbard and Jan Mayen",
            "Sweden",
            "Switzerland",
            "Syrian Arab Republic",
            "Taiwan",
            "Tajikistan",
            "Tanzania, United Republic of",
            "Thailand",
            "Timor-Leste",
            "Togo",
            "Tokelau",
            "Tonga",
            "Trinidad and Tobago",
            "Tunisia",
            "Turkey",
            "Turkmenistan",
            "Turks and Caicos Islands (the)",
            "Tuvalu",
            "Uganda",
            "Ukraine",
            "United Arab Emirates (the)",
            "United Kingdom of Great Britain and Northern Ireland (the)",
            "United States Minor Outlying Islands (the)",
            "United States of America (the)",
            "Uruguay",
            "Uzbekistan",
            "Vanuatu",
            "Venezuela (Bolivarian Republic of)",
            "Viet Nam",
            "Virgin Islands (British)",
            "Virgin Islands (U.S.)",
            "Wallis and Futuna",
            "Western Sahara",
            "Yemen",
            "Zambia",
            "Zimbabwe",
            "Åland Islands"
    };
    }
