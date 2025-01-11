package com.example.cotcscouting.ui.pit_scouting

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
//import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cotcscouting.data.model.AppDatabase
import com.example.cotcscouting.data.model.Pit
import com.example.cotcscouting.databinding.FragmentPitScoutingBinding

class PitScoutingFragment : Fragment() {

    private var _binding: FragmentPitScoutingBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val pitScoutingViewModel =
            ViewModelProvider(this)[PitScoutingViewModel::class.java]

        _binding = FragmentPitScoutingBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView? = binding.textDashboard
        pitScoutingViewModel.text.observe(viewLifecycleOwner) {
            if(textView != null) {
                textView.text = it
            }
        }

        val startingAreaOptions = ArrayList<CheckBox?>()
        startingAreaOptions.add(binding.left)
        startingAreaOptions.add(binding.right)
        startingAreaOptions.add(binding.center)
        setOnClickCheckBoxes(binding.doesMatter, startingAreaOptions)

        val scoreAreaOptions = ArrayList<CheckBox?>()
        scoreAreaOptions.add(binding.amp)
        scoreAreaOptions.add(binding.speaker)
        setOnClickCheckBoxesOneAnswer(binding.ampAndSpeaker, scoreAreaOptions)

        val intakeOptions = ArrayList<CheckBox?>()
        intakeOptions.add(binding.ground)
        intakeOptions.add(binding.source)
        setOnClickCheckBoxes(binding.groundAndSource, intakeOptions)

        val farthestShotOptions = ArrayList<CheckBox?>()
        farthestShotOptions.add(binding.againstSubwoofer)
        farthestShotOptions.add(binding.againstPodium)
        farthestShotOptions.add(binding.againstPodium)
        setOnClickCheckBoxes(binding.wooferPodiumAndWing, farthestShotOptions)

        val sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE)

        binding.submit?.setOnClickListener {
            val pit = Pit(
                0,
                teamNumber = binding.teamNameAnswer?.text.toString(),
                scoutName = sharedPref.getString("scout_name", "Scout").toString(),
                driveCoachName = binding.coachAnswer?.text.toString(),
                driveBase = binding.driveBaseAnswer?.text.toString(),
                rookieTeam = binding.rookieTeam?.isChecked,
                howManyAutos = binding.autoCountNumber?.text.toString(),
                hasAuto = binding.hasAuto?.isChecked,
                doesPreload = binding.doesPreload?.isChecked,
                doesShoot = binding.doesShoot?.isChecked,
                doesIntake = binding.doesIntake?.isChecked,
                whereDoYouStart = checkCheckBoxes(binding.doesMatter, startingAreaOptions),
                whereDoYouScore = checkCheckBoxes(binding.ampAndSpeaker, scoreAreaOptions),
                notesScoreCount = binding.scoreCountAuto?.text.toString(),
                gameStrategy = binding.gameStrategyAnswer?.text.toString(),
                intake = checkCheckBoxes(binding.groundAndSource, intakeOptions),
                farthestShot = checkCheckBoxes(binding.wooferPodiumAndWing, farthestShotOptions),
                doesClimb = binding.canClimb?.isChecked,
                climbTime = binding.climbTimeAnswer?.text.toString(),
                canHarmony = binding.canGetHarmony?.isChecked,
                canScoreTrap = binding.canScoreTrap?.isChecked
            )
            val database = context?.let { it1 -> AppDatabase.getDatabase(it1) }
            database?.pitDAO()?.insert(pit)

            clearFields()
        }

        println(Integer.decode("0"))

        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    /**
     * Set an on click listen for the all box and all the other options.
     * @param all The checkbox which means all
     * @param otherOptionCheckBoxes all other options
     * */
    private fun setOnClickCheckBoxes(all : CheckBox?, otherOptionCheckBoxes: List<CheckBox?>) {
        all?.setOnClickListener {
            for(option: CheckBox? in otherOptionCheckBoxes) {
                option?.isChecked = false
            }
        }
        for(option: CheckBox? in otherOptionCheckBoxes) {
            option?.setOnClickListener {
                all?.isChecked = false
            }
        }
    }

    /**
     * Set an on click listen for the all box and all the other options. If two options are clicked the previous option is unchecked
     * @param all The checkbox which means all
     * @param otherOptionCheckBoxes all other options
     * */
    private fun setOnClickCheckBoxesOneAnswer(all: CheckBox?, otherOptionCheckBoxes: List<CheckBox?>){
        all?.setOnClickListener {
            for(option: CheckBox? in otherOptionCheckBoxes) {
                option?.isChecked = false
            }
        }
        for(option: CheckBox? in otherOptionCheckBoxes) {
            option?.setOnClickListener {
                for(optionsAgain : CheckBox? in otherOptionCheckBoxes) {
                    if(option != optionsAgain) { // In case optionsAgain is the same object as option
                        optionsAgain?.isChecked = false
                    }
                }
                all?.isChecked = false
            }
        }
    }

    /**
     * Finds what checkboxes have been clicked
     * @param all The checkbox which means all
     * @param otherOptionCheckBoxes all other options
     * */
    private fun checkCheckBoxes(all : CheckBox?, otherOptionCheckBoxes: List<CheckBox?>): String {
        val answer = ArrayList<String>()
        var count = 0

        if(all?.isChecked == true) {
            return "All"
        }
        for(option : CheckBox? in otherOptionCheckBoxes) {
            if(option?.isChecked == true) {
                count++
                answer.add(option.text.toString())
            }
        }

        if(count == otherOptionCheckBoxes.size) {
            return "All"
        }

        return answer.toString()
    }

    private fun clearFields() {
        binding.teamNameAnswer?.setText("0")
        binding.coachAnswer?.setText("")
        binding.driveBaseAnswer?.setText("")
        binding.rookieTeam?.isChecked = false
        binding.autoCountNumber?.setText("0")
        binding.hasAuto?.isChecked = false
        binding.doesPreload?.isChecked = false
        binding.doesShoot?.isChecked = false
        binding.doesIntake?.isChecked = false
        binding.doesMatter?.isChecked = false
        binding.ampAndSpeaker?.isChecked = false
        binding.scoreCountAuto?.setText("0")
        binding.gameStrategyAnswer?.setText("")
        binding.groundAndSource?.isChecked = false
        binding.wooferPodiumAndWing?.isChecked = false
        binding.canClimb?.isChecked = false
        binding.climbTimeAnswer?.setText("0")
        binding.canGetHarmony?.isChecked = false
        binding.canScoreTrap?.isChecked = false
    }

    // TODO: THIS FUNCTION SHOULDN'T RETURN ANYTHING THAT'S WHAT'S CAUSING THE PROBLEM. MY LOVELY FOCUS LISTENER LIVES ONCE AGAIN!!!!!!!
    /**
     * My sweet child which unironically took me like 2 hours to make can work again. Soon... Soon....
     * */
//    fun focusListenerString(textBoxID : EditText?): String {
//        var answer = ""
//        val originalText = textBoxID?.text
//
//        textBoxID?.setOnFocusChangeListener {
//                v: View,
//                _: Boolean ->
//
//            fun onFocusChange(v: View) {
//                // if teamAnswerBox is equal to the text which was originally in the text box
//                if(textBoxID.text.toString() == originalText.toString() || textBoxID.text.isBlank()) {
//                    // If textBoxID is not focused, then reset textBoxID to it's original text
//                    if(!v.hasFocus()) {
//                        textBoxID.text = originalText
//                    } else { // Since textBoxID is now focused clear it so the text doesn't need to be cleared
//                        textBoxID.text.clear()
//                    }
//                } else { // Since textBoxID isn't equal to the text which was originally in the box
//                    answer = textBoxID.text.toString()
//                }
//            }
//            onFocusChange(v) // Run on change function
//        }
//
//        return answer
//    }
}