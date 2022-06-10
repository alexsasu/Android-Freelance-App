//package com.example.postolache_predescu_sandur_sasu.database;
//
//import android.content.Intent;
//import android.os.Bundle;
//
//import com.example.postolache_predescu_sandur_sasu.R;
//import com.example.postolache_predescu_sandur_sasu.model.CartAndHistory;
//import com.example.postolache_predescu_sandur_sasu.model.CartAndHistoryRVAAdapter;
//import com.example.postolache_predescu_sandur_sasu.model.City;
//import com.example.postolache_predescu_sandur_sasu.model.CityRVAAdapter;
//import com.example.postolache_predescu_sandur_sasu.model.Job;
//import com.example.postolache_predescu_sandur_sasu.model.JobRVAAdapter;
//import com.example.postolache_predescu_sandur_sasu.model.Language;
//import com.example.postolache_predescu_sandur_sasu.model.LanguageRVAdapter;
//import com.example.postolache_predescu_sandur_sasu.model.Speaks;
//import com.example.postolache_predescu_sandur_sasu.model.SpeaksRVAAdapter;
//import com.example.postolache_predescu_sandur_sasu.model.User;
//import com.example.postolache_predescu_sandur_sasu.model.UserRVAAdapter;
//import com.example.postolache_predescu_sandur_sasu.model.ViewCartAndHistory;
//import com.example.postolache_predescu_sandur_sasu.model.ViewCity;
//import com.example.postolache_predescu_sandur_sasu.model.ViewJob;
//import com.example.postolache_predescu_sandur_sasu.model.ViewLanguage;
//import com.example.postolache_predescu_sandur_sasu.model.ViewSpeaks;
//import com.example.postolache_predescu_sandur_sasu.model.ViewUser;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.view.View;
//
//import androidx.navigation.NavController;
//import androidx.navigation.Navigation;
//import androidx.navigation.ui.AppBarConfiguration;
//import androidx.navigation.ui.NavigationUI;
//
//import com.example.postolache_predescu_sandur_sasu.databinding.ActivityMainBinding;
//
//import android.view.Menu;
//import android.view.MenuItem;
//
//
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.lifecycle.Observer;
//import androidx.lifecycle.ViewModelProviders;
//import androidx.recyclerview.widget.ItemTouchHelper;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//
//import java.util.List;
//
//public class MainActivity extends AppCompatActivity {
//
//    private AppBarConfiguration appBarConfiguration;
//    private ActivityMainBinding binding;
//
//    private RecyclerView citiesRV;
//    private RecyclerView jobsRV;
//    private RecyclerView languagesRV;
//    private RecyclerView usersRV;
//    private RecyclerView speakssRV;
//    private RecyclerView cartsandhistoriesRV;
//
//    private static final int ADD_CITY_REQUEST = 1;
//    private static final int EDIT_CITY_REQUEST = 2;
//    private static final int ADD_JOB_REQUEST = 1;
//    private static final int EDIT_JOB_REQUEST = 2;
//    private static final int ADD_LANGUAGE_REQUEST = 1;
//    private static final int EDIT_LANGUAGE_REQUEST = 2;
//    private static final int ADD_USER_REQUEST = 1;
//    private static final int EDIT_USER_REQUEST = 2;
//    private static final int ADD_SPEAKS_REQUEST = 1;
//    private static final int EDIT_SPEAKS_REQUEST = 2;
//    private static final int ADD_CART_AND_HISTORY_REQUEST = 1;
//    private static final int EDIT_CART_AND_HISTORY_REQUEST = 2;
//
//    private ViewCity viewcity;
//    private ViewJob viewjob;
//    private ViewLanguage viewlanguage;
//    private ViewUser viewuser;
//    private ViewSpeaks viewspeaks;
//    private ViewCartAndHistory viewcartandhistory;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        citiesRV = findViewById(R.id.idRVCities);
//        jobsRV = findViewById(R.id.idRVJobs);
//        languagesRV = findViewById(R.id.idRVLanguages);
//        usersRV = findViewById(R.id.idRVUsers);
//        speakssRV = findViewById(R.id.idRVSpeaks);
//        cartsandhistoriesRV = findViewById(R.id.idRVCartsAndHistories);
//
//        FloatingActionButton fabCities = findViewById(R.id.idFABAddCities);
//        FloatingActionButton fabJobs = findViewById(R.id.idFABAddJobs);
//        FloatingActionButton fabLanguages = findViewById(R.id.idFABAddLanguages);
//        FloatingActionButton fabUsers = findViewById(R.id.idFABAddUsers);
//        FloatingActionButton fabSpeakss = findViewById(R.id.idFABAddSpeakss);
//        FloatingActionButton fabCartsAndHistories = findViewById(R.id.idFABAddCartsAndHistories);
//
//
//        fabCities.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, NewCityActivity.class);
//                startActivityForResult(intent, ADD_CITY_REQUEST);
//            }
//        });
//
//        fabJobs.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intentJob = new Intent(MainActivity.this, NewJobActivity.class);
//                startActivityForResult(intentJob, ADD_JOB_REQUEST);
//            }
//        });
//
//        fabLanguages.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, NewLanguageActivity.class);
//                startActivityForResult(intent, ADD_LANGUAGE_REQUEST);
//            }
//        });
//
//        fabUsers.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, NewUserActivity.class);
//                startActivityForResult(intent, ADD_USER_REQUEST);
//            }
//        });
//
//        fabSpeakss.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, NewUserActivity.class);
//                startActivityForResult(intent, ADD_SPEAKS_REQUEST);
//            }
//        });
//
//        fabCartsAndHistories.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, NewUserActivity.class);
//                startActivityForResult(intent, ADD_CART_AND_HISTORY_REQUEST);
//            }
//        });
//
//
//        citiesRV.setLayoutManager(new LinearLayoutManager(this));
//        citiesRV.setHasFixedSize(true);
//
//        jobsRV.setLayoutManager(new LinearLayoutManager(this));
//        jobsRV.setHasFixedSize(true);
//
//        languagesRV.setLayoutManager(new LinearLayoutManager(this));
//        languagesRV.setHasFixedSize(true);
//
//        usersRV.setLayoutManager(new LinearLayoutManager(this));
//        usersRV.setHasFixedSize(true);
//
//        speakssRV.setLayoutManager(new LinearLayoutManager(this));
//        speakssRV.setHasFixedSize(true);
//
//        cartsandhistoriesRV.setLayoutManager(new LinearLayoutManager(this));
//        cartsandhistoriesRV.setHasFixedSize(true);
//
//        final CityRVAAdapter adapter = new CityRVAAdapter();
//        final JobRVAAdapter jobAdapter = new JobRVAAdapter();
//        final LanguageRVAdapter languageAdapter = new LanguageRVAdapter();
//        final UserRVAAdapter userAdapter = new UserRVAAdapter();
//        final SpeaksRVAAdapter speaksAdapter = new SpeaksRVAAdapter();
//        final CartAndHistoryRVAAdapter cartandhistoryAdapter = new CartAndHistoryRVAAdapter();
//
//        citiesRV.setAdapter(adapter);
//        jobsRV.setAdapter(jobAdapter);
//        languagesRV.setAdapter(languageAdapter);
//        usersRV.setAdapter(userAdapter);
//        speakssRV.setAdapter(speaksAdapter);
//        cartsandhistoriesRV.setAdapter(cartandhistoryAdapter);
//
//        viewcity = ViewModelProviders.of(this).get(ViewCity.class);
//        viewjob = ViewModelProviders.of(this).get(ViewJob.class);
//        viewlanguage = ViewModelProviders.of(this).get(ViewLanguage.class);
//        viewuser = ViewModelProviders.of(this).get(ViewUser.class);
//        viewspeaks = ViewModelProviders.of(this).get(ViewSpeaks.class);
//        viewcartandhistory = ViewModelProviders.of(this).get(ViewCartAndHistory.class);
//
//        viewcity.getAllCity().observe(this, new Observer<List<City>>() {
//            @Override
//            public void onChanged(List<City> models) {
//
//                adapter.submitList(models);
//            }
//        });
//
//        viewjob.getAllJobs().observe(this, new Observer<List<Job>>() {
//            @Override
//            public void onChanged(List<Job> models) {
//
//                jobAdapter.submitList(models);
//            }
//        });
//
//        viewlanguage.getAllLanguages().observe(this, new Observer<List<Language>>() {
//            @Override
//            public void onChanged(List<Language> models) {
//
//                languageAdapter.submitList(models);
//            }
//        });
//
//        viewuser.getAllUsers().observe(this, new Observer<List<User>>() {
//            @Override
//            public void onChanged(List<User> models) {
//
//                userAdapter.submitList(models);
//            }
//        });
//
//        viewspeaks.getAllSpeakss().observe(this, new Observer<List<Speaks>>() {
//            @Override
//            public void onChanged(List<Speaks> models) {
//
//                speaksAdapter.submitList(models);
//            }
//        });
//
//        viewcartandhistory.getAllCartsAndHistories().observe(this, new Observer<List<CartAndHistory>>() {
//            @Override
//            public void onChanged(List<CartAndHistory> models) {
//
//                cartandhistoryAdapter.submitList(models);
//            }
//        });
//
//        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
//            @Override
//            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
//                return false;
//            }
//
//            @Override
//            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
//
//                viewcity.delete(adapter.getCityAt(viewHolder.getAdapterPosition()));
//                Toast.makeText(MainActivity.this, "City deleted", Toast.LENGTH_SHORT).show();
//            }
//        }).attachToRecyclerView(citiesRV);
//
//        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
//            @Override
//            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
//                return false;
//            }
//
//            @Override
//            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
//
//                viewjob.delete(jobAdapter.getJobAt(viewHolder.getAdapterPosition()));
//                Toast.makeText(MainActivity.this, "Job deleted", Toast.LENGTH_SHORT).show();
//            }
//        }).attachToRecyclerView(jobsRV);
//
//
//        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
//            @Override
//            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
//                return false;
//            }
//
//            @Override
//            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
//
//                viewlanguage.delete(languageAdapter.getLanguageAt(viewHolder.getAdapterPosition()));
//                Toast.makeText(MainActivity.this, "Language deleted", Toast.LENGTH_SHORT).show();
//            }
//        }).attachToRecyclerView(languagesRV);
//
//
//        adapter.setOnItemClickListener(new CityRVAAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(City model) {
//
//                Intent intent = new Intent(MainActivity.this, NewCityActivity.class);
//                intent.putExtra(NewCityActivity.EXTRA_ID, model.getIdCity());
//                intent.putExtra(NewCityActivity.EXTRA_CITY_NAME, model.getName());
//                startActivityForResult(intent, EDIT_CITY_REQUEST);
//            }
//
//            ////////////
//            public void onItemClick(Job model) {
//
//                Intent intentJob = new Intent(MainActivity.this, NewJobActivity.class);
//                intentJob.putExtra(NewJobActivity.EXTRA_ID, model.getIdJob());
//                intentJob.putExtra(NewJobActivity.EXTRA_JOB_NAME, model.getDomainOfWork());
//                startActivityForResult(intentJob, EDIT_JOB_REQUEST);
//            }
//
//            ///////////
//            public void onItemClick(Language model) {
//                Intent intentLanguage = new Intent(MainActivity.this, NewLanguageActivity.class);
//                intentLanguage.putExtra(NewLanguageActivity.EXTRA_ID, model.getIdLanguage());
//                intentLanguage.putExtra(NewLanguageActivity.EXTRA_LANGUAGE_NAME, model.getLanguageName());
//
//                startActivityForResult(intentLanguage, EDIT_LANGUAGE_REQUEST);
//            }
//            /////////////
//
//            public void onItemClick(User model) {
//                Intent intentUser = new Intent(MainActivity.this, NewUserActivity.class);
//                intentUser.putExtra(NewUserActivity.EXTRA_ID, model.getIdUser());
//                intentUser.putExtra(NewUserActivity.EXTRA_PHONE_NUMBER, model.getPhoneNumber());
//
//                startActivityForResult(intentUser, EDIT_USER_REQUEST);
//            }
//
//            public void onItemClick(Speaks model) {
//                Intent intentSpeaks = new Intent(MainActivity.this, NewSpeaksActivity.class);
//                intentSpeaks.putExtra(NewSpeaksActivity.EXTRA_ID, model.getId_fK_User());
//                intentSpeaks.putExtra(NewSpeaksActivity.EXTRA_USER_ID, model.getId_fK_User());
//
//                startActivityForResult(intentSpeaks, EDIT_SPEAKS_REQUEST);
//            }
//
//            /////////
//            public void onItemClick(CartAndHistory model) {
//                Intent intentCartAndHistory = new Intent(MainActivity.this, NewCartAndHistoryActivity.class);
//                intentCartAndHistory.putExtra(NewCartAndHistoryActivity.EXTRA_ID, model.getIdUtility());
//                intentCartAndHistory.putExtra(NewCartAndHistoryActivity.EXTRA_FEEDBACK, model.getFeedback());
//
//                startActivityForResult(intentCartAndHistory, EDIT_CART_AND_HISTORY_REQUEST);
//            }
//        });
//
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == ADD_CITY_REQUEST && resultCode == RESULT_OK) {
//            String cityName = data.getStringExtra(NewCityActivity.EXTRA_CITY_NAME);
//            City model = new City(cityName);
//            viewcity.insert(model);
//            Toast.makeText(this, "City saved", Toast.LENGTH_SHORT).show();
//        } else if (requestCode == EDIT_CITY_REQUEST && resultCode == RESULT_OK) {
//            int id = data.getIntExtra(NewCityActivity.EXTRA_ID, -1);
//
//            if (id == -1) {
//                Toast.makeText(this, "City can't be updated", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            String cityName = data.getStringExtra(NewCityActivity.EXTRA_CITY_NAME);
//            City model = new City(cityName);
//            model.setIdCity(id);
//            viewcity.update(model);
//            Toast.makeText(this, "City updated", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "City not saved", Toast.LENGTH_SHORT).show();
//        }
//
//
//        if (requestCode == ADD_JOB_REQUEST && resultCode == RESULT_OK) {
//            String jobName = data.getStringExtra(NewJobActivity.EXTRA_JOB_NAME);
//            Job model = new Job(jobName);
//            viewjob.insert(model);
//            Toast.makeText(this, "Job saved", Toast.LENGTH_SHORT).show();
//        } else if (requestCode == EDIT_JOB_REQUEST && resultCode == RESULT_OK) {
//            int id = data.getIntExtra(NewJobActivity.EXTRA_ID, -1);
//            if (id == -1) {
//                Toast.makeText(this, "Job can't be updated", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            String jobName = data.getStringExtra(NewJobActivity.EXTRA_JOB_NAME);
//            Job model = new Job(jobName);
//            model.setIdJob(id);
//            viewjob.update(model);
//            Toast.makeText(this, "Job updated", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "Job not saved", Toast.LENGTH_SHORT).show();
//        }
//
//
//        if (requestCode == ADD_LANGUAGE_REQUEST && resultCode == RESULT_OK) {
//            String languageName = data.getStringExtra(NewJobActivity.EXTRA_JOB_NAME);
//            Language model = new Language(languageName);
//            viewlanguage.insert(model);
//            Toast.makeText(this, "Language saved", Toast.LENGTH_SHORT).show();
//        } else if (requestCode == EDIT_LANGUAGE_REQUEST && resultCode == RESULT_OK) {
//            int id = data.getIntExtra(NewLanguageActivity.EXTRA_ID, -1);
//            if (id == -1) {
//                Toast.makeText(this, "Language can't be updated", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            String languageName = data.getStringExtra(NewLanguageActivity.EXTRA_LANGUAGE_NAME);
//            Language model = new Language(languageName);
//            model.setIdLanguage(id);
//            viewlanguage.update(model);
//            Toast.makeText(this, "Language updated", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "Language not saved", Toast.LENGTH_SHORT).show();
//        }
//
//        if (requestCode == ADD_USER_REQUEST && resultCode == RESULT_OK) {
//            String phoneNumber = data.getStringExtra(NewUserActivity.EXTRA_PHONE_NUMBER);
//            User model = new User(phoneNumber);
//            viewuser.insert(model);
//            Toast.makeText(this, "User saved", Toast.LENGTH_SHORT).show();
//        } else if (requestCode == EDIT_USER_REQUEST && resultCode == RESULT_OK) {
//            int id = data.getIntExtra(NewUserActivity.EXTRA_ID, -1);
//            if (id == -1) {
//                Toast.makeText(this, "User can't be updated", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            String phoneNumber = data.getStringExtra(NewUserActivity.EXTRA_PHONE_NUMBER);
//            User model = new User(phoneNumber);
//            model.setIdUser(id);
//            viewuser.update(model);
//            Toast.makeText(this, "User updated", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "User not saved", Toast.LENGTH_SHORT).show();
//        }
//
//
//        if (requestCode == ADD_SPEAKS_REQUEST && resultCode == RESULT_OK) {
//            Integer speaksIdFK = data.getIntExtra(NewSpeaksActivity.EXTRA_USER_ID, 0);
//            Speaks model = new Speaks(speaksIdFK);
//            viewspeaks.insert(model);
//            Toast.makeText(this, "Speaks saved", Toast.LENGTH_SHORT).show();
//        } else if (requestCode == EDIT_SPEAKS_REQUEST && resultCode == RESULT_OK) {
//            int id = data.getIntExtra(NewSpeaksActivity.EXTRA_ID, -1);
//            if (id == -1) {
//                Toast.makeText(this, "Speaks can't be updated", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            Integer speaksIdFK = data.getIntExtra(NewSpeaksActivity.EXTRA_USER_ID, 0);
//            Speaks model = new Speaks(speaksIdFK);
//            model.setId_fK_User(id);
//            viewspeaks.update(model);
//            Toast.makeText(this, "Speaks updated", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "Speaks not saved", Toast.LENGTH_SHORT).show();
//        }
//
//        if (requestCode == ADD_CART_AND_HISTORY_REQUEST && resultCode == RESULT_OK) {
//            Integer utilityId = data.getIntExtra(NewCartAndHistoryActivity.EXTRA_ID, 0);
//            CartAndHistory model = new CartAndHistory(utilityId);
//            viewcartandhistory.insert(model);
//            Toast.makeText(this, "Cart and history saved", Toast.LENGTH_SHORT).show();
//        } else if (requestCode == EDIT_CART_AND_HISTORY_REQUEST && resultCode == RESULT_OK) {
//            int id = data.getIntExtra(NewCartAndHistoryActivity.EXTRA_ID, -1);
//            if (id == -1) {
//                Toast.makeText(this, "Cart and history can't be updated", Toast.LENGTH_SHORT).show();
//                return;
//            }
//
//            Integer utilityId = data.getIntExtra(NewCartAndHistoryActivity.EXTRA_ID, 0);
//            CartAndHistory model = new CartAndHistory(utilityId);
//            model.setIdUtility(id);
//            viewcartandhistory.update(model);
//            Toast.makeText(this, "Cart and history updated", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(this, "Cart and history not saved", Toast.LENGTH_SHORT).show();
//        }
//    }
//}