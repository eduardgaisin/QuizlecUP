package com.eduardg.quizlec

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.internal.ContextUtils.getActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // navBar
        /*
        var navBar = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        navBar.setOnNavigationItemSelectedListener {item ->
            when(item.itemId){
                R.id.page_training -> {
                    findNavController(R.id.nav_host_fragment).popBackStack()
                    findNavController(R.id.nav_host_fragment).navigate(R.id.chooseCardCollectionFragment)
                    true
                }
                R.id.page_card_collections -> {
                    findNavController(R.id.nav_host_fragment).popBackStack()
                    findNavController(R.id.nav_host_fragment).navigate(R.id.cardCollectionListFragment)
                    true
                }
                else -> false
            }
        }

        <com.google.android.material.bottomnavigation.BottomNavigationView
        android:id="@+id/bottom_navigation"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/nav_host_fragment"
        app:menu="@menu/bottom_navigation_menu" />

         */
    }
}