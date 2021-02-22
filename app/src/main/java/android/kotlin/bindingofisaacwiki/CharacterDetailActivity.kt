package android.kotlin.bindingofisaacwiki

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class CharacterDetailActivity : AppCompatActivity() {

    companion object {
        val EXTRA_CHARACTER = "character"
        val EXTRA_CHARACTER_INDEX = "characterIndex"
    }

    lateinit var character: Character
    var characterIndex: Int = -1

    lateinit var adapter: HeartAdapter

    lateinit var characterNameView: TextView
    lateinit var characterIconView: ImageView
    lateinit var characterDamageView: TextView
    lateinit var characterTearsView: TextView
    lateinit var characterShotSpeedView: TextView
    lateinit var characterRangeView: TextView
    lateinit var characterSpeedView: TextView
    lateinit var characterLuckView: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_character_detail)

        character = intent.getParcelableExtra<Character>(EXTRA_CHARACTER)
        characterIndex = intent.getIntExtra(EXTRA_CHARACTER_INDEX, -1)
        characterNameView = findViewById<TextView>(R.id.character_name)
        characterIconView = findViewById<ImageView>(R.id.character_icon)
        characterDamageView = findViewById<TextView>(R.id.damage)
        characterTearsView = findViewById<TextView>(R.id.tears)
        characterShotSpeedView = findViewById<TextView>(R.id.shot_speed)
        characterRangeView = findViewById<TextView>(R.id.range)
        characterSpeedView = findViewById<TextView>(R.id.speed)
        characterLuckView = findViewById<TextView>(R.id.luck)

        characterNameView.text = character.name
        characterIconView.setImageResource(character.icon)
        characterDamageView.text = character.damage.toString()
        characterTearsView.text = character.tears.toString()
        characterShotSpeedView.text = character.speed.toString()
        characterRangeView.text = character.range.toString()
        characterSpeedView.text = character.speed.toString()
        characterLuckView.text = character.luck.toString()


        adapter = HeartAdapter(character)

        val recyclerView = findViewById<RecyclerView>(R.id.hearts_recycler_view)
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = adapter


    }
}