package android.kotlin.bindingofisaacwiki

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.characters_list_button).setOnClickListener() {
            Toast.makeText(this,"Liste de personnages", Toast.LENGTH_SHORT).show()
            intent = Intent(applicationContext, CharactersListActivity::class.java)
            startActivity(intent)
        }
    }
}