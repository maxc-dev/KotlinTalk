package dev.maxc.talk.speech

import edu.cmu.sphinx.api.Configuration
import edu.cmu.sphinx.api.LiveSpeechRecognizer

import java.io.IOException


/**
 * @author Max Carter
 * @since 28/09/2020
 */
class SpeechRecogniser {
    lateinit var recogniser: LiveSpeechRecognizer

    init {
        val configuration = Configuration()

        configuration.acousticModelPath = "resource:/edu/cmu/sphinx/models/en-us/en-us"
        configuration.dictionaryPath = "resource:/edu/cmu/sphinx/models/en-us/cmudict-en-us.dict"

        configuration.grammarPath = "src/main/resources"
        configuration.grammarName = "text"
        configuration.useGrammar = true

        try {
            recogniser = LiveSpeechRecognizer(configuration)
        } catch (ex: IOException) {
            ex.printStackTrace()
        }

        val speechThread = Thread {
            recogniser.startRecognition(true)
            while (true) {
                val speechResult = recogniser.result.hypothesis
                if (speechResult != null) {
                    println(speechResult)
                }
            }
        }
        speechThread.start()
    }
}