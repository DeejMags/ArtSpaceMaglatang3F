package com.example.artspacemaglatangrodrigon3f

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.artspacemaglatangrodrigon3f.R
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var artworkImageView: ImageView
    private lateinit var artworkTitleTextView: TextView
    private lateinit var artworkAuthorTextView: TextView
    private lateinit var artworkDescriptionTextView: TextView
    private lateinit var previousButton: MaterialButton
    private lateinit var nextButton: MaterialButton

    private val artworks = listOf(
        Artwork(
            R.drawable.wp7130844,
            "Spider-Man Comics",
            "Stan Lee & Steve Ditko",
            "The debut of Spider-Man in Marvel Comics (1962). This was the first appearance of Peter Parker as Spider-Man, created by Stan Lee and Steve Ditko. A turning point in the superhero genre, where a teenager could be a hero."
        ),
        Artwork(
            R.drawable.spider_man_1_2_3_sam_raimi_posters,
            "Spider-Man (2002)",
            "Sam Raimi",
            "The 2002 live-action movie that revolutionized superhero cinema. Directed by Sam Raimi, it introduced Tobey Maguire as Peter Parker/Spider-Man, and became an instant box office hit."
        ),
        Artwork(
            R.drawable.spider_man_into_the_spider_verse_2,
            "Spider-Man: Into the Spider-Verse",
            "Phil Lord & Christopher Miller",
            "An animated masterpiece released in 2018. This movie introduced the multiverse concept, bringing together different versions of Spider-Man, and won an Academy Award for Best Animated Feature."
        ),
        Artwork(
            R.drawable.hq720,
            "Marvel's Spider-Man (PS4)",
            "Insomniac Games",
            "Released in 2018, this video game brought a fresh take on the Spider-Man character, with high-quality graphics, a thrilling open-world environment, and a mature Peter Parker."
        ),
        Artwork(
            R.drawable.spider_man_no_way_home_spoiler_feature_image,
            "Spider-Man: No Way Home",
            "Jon Watts",
            "The 2021 blockbuster that brought together three generations of Spider-Man actors in one epic movie. Directed by Jon Watts, it became a major success and marked a significant moment in the Marvel Cinematic Universe."
        )
    )

    private var currentArtworkIndex = 0
    private var isFirstArtwork: Boolean = true
    private var isLastArtwork: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        artworkImageView = findViewById(R.id.artworkImageView)
        artworkTitleTextView = findViewById(R.id.artworkTitleTextView)
        artworkAuthorTextView = findViewById(R.id.artworkAuthorTextView)
        artworkDescriptionTextView = findViewById(R.id.artworkDescriptionTextView)
        previousButton = findViewById(R.id.previousButton)
        nextButton = findViewById(R.id.nextButton)

        updateArtworkDisplay()
        updateNavigationButtons()

        previousButton.setOnClickListener {
            navigateArtwork(false)
        }

        nextButton.setOnClickListener {
            navigateArtwork(true)
        }
    }

    private fun navigateArtwork(goForward: Boolean) {
        currentArtworkIndex = when {
            goForward -> (currentArtworkIndex + 1) % artworks.size
            else -> (currentArtworkIndex - 1 + artworks.size) % artworks.size
        }
        updateArtworkDisplay()
        updateNavigationButtons()
    }

    private fun updateArtworkDisplay() {
        val currentArtwork = artworks[currentArtworkIndex]
        artworkImageView.setImageResource(currentArtwork.imageResourceId)
        artworkTitleTextView.text = currentArtwork.title
        artworkAuthorTextView.text = currentArtwork.author
        artworkDescriptionTextView.text = currentArtwork.description
    }

    private fun updateNavigationButtons() {
        isFirstArtwork = currentArtworkIndex == 0
        isLastArtwork = currentArtworkIndex == artworks.size - 1

        previousButton.isEnabled = !isFirstArtwork
        nextButton.isEnabled = !isLastArtwork

        previousButton.alpha = if (isFirstArtwork) 0.5f else 1.0f
        nextButton.alpha = if (isLastArtwork) 0.5f else 1.0f
    }
}

data class Artwork(
    val imageResourceId: Int,
    val title: String,
    val author: String,
    val description: String
)