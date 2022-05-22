package com.example.uiexamples


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.isVisible
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.uiexamples.ui.gallery.GalleryFragment
import com.example.uiexamples.ui.home.HomeFragment
import com.example.uiexamples.ui.slideshow.SlideshowFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar


class MenuExample : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var homeFragment: HomeFragment
    private lateinit var galleryFragment: GalleryFragment
    private lateinit var slideshowFragment: SlideshowFragment
    private lateinit var nombreUsuario: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_example)

        val bundle = intent.extras
        val msg = bundle!!.getString("msg")
        val l =  bundle.getSerializable("Login") as Persona
        nombreUsuario = l.nombre
        if (msg != null) {
            Toast.makeText(this, "$msg ${l.nombre} ${l.password}", Toast.LENGTH_SHORT).show()
        }

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)


        if(l.rol!="admin"){
            val navAk7: NavigationView = findViewById(R.id.nav_view) as NavigationView
            val nav_per: Menu = navAk7.getMenu()
            nav_per.findItem(R.id.nav_personas).setVisible(false)
        }else{
            val navAk7: NavigationView = findViewById(R.id.nav_view) as NavigationView
            val nav_per: Menu = navAk7.getMenu()
            nav_per.findItem(R.id.nav_jobApp).setVisible(false)
        }

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        navView.setNavigationItemSelectedListener(this)


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_example, menu)
        return true
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId){
            R.id.nav_home -> {
                homeFragment = HomeFragment()
                supportFragmentManager
                    .beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.nav_host_fragment, homeFragment)
                    .addToBackStack(null)
                    .commit()

            }
            R.id.nav_gallery -> {
                galleryFragment = GalleryFragment()
                supportFragmentManager
                    .beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.nav_host_fragment, galleryFragment)
                    .addToBackStack(null)
                    .commit()

            }
            R.id.nav_slideshow -> {
                slideshowFragment = SlideshowFragment()
                supportFragmentManager
                    .beginTransaction()
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                    .replace(R.id.nav_host_fragment, slideshowFragment)
                    .addToBackStack(null)
                    .commit()
            }
            R.id.nav_jobApp -> {
                var objForm:JobForm = JobForm(nombreUsuario ,"Smith","Street 16, Avenue 6","Street 20, Avenue 5","Barva","Heredia","11010","Costa Rica",(nombreUsuario + "@una.cr"),"506","89508209","Web developer","04/29/2022")
                val i = Intent(this, JobApp::class.java)
                i.putExtra( "objeto", objForm)
                startActivity(i)
            }
            R.id.nav_personas -> {
                val i = Intent(this, CrudPersonas::class.java)
                startActivity(i)
            }
            R.id.salir -> {
                val i = Intent(this, LoginExample::class.java)
                startActivity(i)
                finish()
            }
        }
        return true
    }
    override fun onBackPressed() {
        val fragments = supportFragmentManager.backStackEntryCount
        if (fragments == 1) {
            finish()
            return
        }
        super.onBackPressed()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}