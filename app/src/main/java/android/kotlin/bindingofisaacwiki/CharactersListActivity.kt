package android.kotlin.bindingofisaacwiki

import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CharactersListActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var characters: MutableList<Character>
    lateinit var adapter: CharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_characters_list)

        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        characters = arrayListOf<Character>()
        characters.add(Character("Isaac", 3.5F,+ 0,1,23.75F,1F,0 ,"D6", R.drawable.isaac,3))
        characters.add(Character("Magdalene", 3.5F, + 0,1,23.75F,0.85F,0,"Yum heart", R.drawable.magdalene,2))
        characters.add(Character("Cain", 3.5F, + 0, 1,17.75F,1.3F, 0,"Lucky foot", R.drawable.cain,5))
        characters.add(Character("Judas",3.5F, + 0,1,23.75F, 1F,0, "The Book of Belial", R.drawable.judas,1))

        adapter = CharacterAdapter(characters, this)

        val recyclerView = findViewById<RecyclerView>(R.id.characters_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    override fun onClick(view: View) {
        if (view.tag != null) {
            showCharacterDetail(view.tag as Int)
        }

    }


    private fun showCharacterDetail(characterIndex: Int) {
        val character = characters[characterIndex]
        val intent = Intent(this, CharacterDetailActivity::class.java)
        intent.putExtra(CharacterDetailActivity.EXTRA_CHARACTER, character)
        intent.putExtra(CharacterDetailActivity.EXTRA_CHARACTER_INDEX, characterIndex)
        startActivity(intent)
    }
}



