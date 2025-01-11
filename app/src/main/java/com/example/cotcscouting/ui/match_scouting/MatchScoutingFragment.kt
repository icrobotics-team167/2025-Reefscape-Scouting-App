package com.example.cotcscouting.ui.match_scouting

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.cotcscouting.data.model.AppDatabase
import com.example.cotcscouting.data.model.Match
import com.example.cotcscouting.databinding.FragmentMatchScoutingBinding
import org.json.JSONArray
import org.json.JSONObject
import java.net.URL
import java.util.StringTokenizer

class MatchScoutingFragment : Fragment()  {

    private var _binding: FragmentMatchScoutingBinding? = null
    private val newMatch = Match(
        uid = 0,
        autoAmpCount= 0,
        autoSpeakerCount= 0,
        teleopAmpCount= 0,
        teleOpSpeakerCount= 0,
        leave= false,
        onStage= false,
        onStageSpotlit= false,
        trapNote= 0,
        park= false,
        defense= false,
        disabledRobot= false,
        shootingDistanceBar= 0,
        teamNumber= "",
        matchNumber= "",
        matchNotes= "",
        scoutName= "",
        regionalCode= "iowa",
    )
    private var activeMatch = newMatch.copy()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    //TODO: Update the event key
    private val blueAllianceURL = "https://www.thebluealliance.com/api/v3/match/2024iacf_qm"
    private val blueAllianceAuthKey = "?X-TBA-Auth-Key=9wSxnqP56MMgj6T8SsoQVOprfnX4uGp1YHGq7GLUYv8fmLXk0PYOqEeSR6QRtv3w"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val matchScoutingViewModal =
            ViewModelProvider(this)[MatchScoutingViewModel::class.java]

        _binding = FragmentMatchScoutingBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView? = binding.textDashboard
        matchScoutingViewModal.text.observe(viewLifecycleOwner) {
            if (textView != null) {
                textView.text = it
            }
        }

        val sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE)
        binding.scoutName?.text = sharedPref.getString("scout_name", "Scout").toString()
        binding.scoutAssignment?.text = sharedPref.getString("scout_assignment", "Red 1").toString()

        binding.autoAmpDec?.setOnClickListener {
            if(activeMatch.autoAmpCount > 0) {
                activeMatch.autoAmpCount--
            }
            binding.ampNoteAuto?.text = activeMatch.autoAmpCount.toString()
        }

        binding.autoAmpInc?.setOnClickListener {
            activeMatch.autoAmpCount++
            binding.ampNoteAuto?.text = activeMatch.autoAmpCount.toString()
        }

        binding.autoSpeakerDec?.setOnClickListener {
            if(activeMatch.autoSpeakerCount > 0) {
                activeMatch.autoSpeakerCount--
            }
            binding.speakerNoteAuto?.text = activeMatch.autoSpeakerCount.toString()
        }

        binding.autoSpeakerInc?.setOnClickListener {
            activeMatch.autoSpeakerCount++
            binding.speakerNoteAuto?.text = activeMatch.autoSpeakerCount.toString()
        }

        binding.teleOpAmpDec?.setOnClickListener {
            if(activeMatch.teleopAmpCount > 0) {
                activeMatch.teleopAmpCount--
            }
            binding.ampNoteTeleOp?.text = activeMatch.teleopAmpCount.toString()
        }

        binding.teleOpAmpInc?.setOnClickListener {
            activeMatch.teleopAmpCount++
            binding.ampNoteTeleOp?.text = activeMatch.teleopAmpCount.toString()
        }
        binding.teleOpSpeakerDec?.setOnClickListener {
            if(activeMatch.teleOpSpeakerCount > 0) {
                activeMatch.teleOpSpeakerCount--
            }
            binding.teleOpSpeaker?.text = activeMatch.teleOpSpeakerCount.toString()
        }

        binding.teleOpSpeakerInc?.setOnClickListener {
            activeMatch.teleOpSpeakerCount++
            binding.teleOpSpeaker?.text = activeMatch.teleOpSpeakerCount.toString()
        }

        binding.leave?.setOnClickListener {
            activeMatch.leave = binding.leave?.isChecked == true
        }
        binding.onStage?.setOnClickListener {
            activeMatch.onStage = binding.onStage?.isChecked == true
        }

        binding.onStageSpotlit?.setOnClickListener {
            activeMatch.onStageSpotlit = binding.onStageSpotlit?.isChecked == true
        }

        binding.trapNote?.setOnClickListener {
            activeMatch.trapNote = if (binding.trapNote?.isChecked == true) {
                1
            } else {
                0
            }
        }

        binding.park?.setOnClickListener {
            activeMatch.park = binding.park?.isChecked == true
        }

        binding.defense?.setOnClickListener {
            activeMatch.defense = binding.defense?.isChecked == true
        }

        binding.disabledRobot?.setOnClickListener {
            activeMatch.disabledRobot = binding.disabledRobot?.isChecked == true
        }

            binding.shootingDistanceBar?.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                activeMatch.shootingDistanceBar = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {}

            override fun onStopTrackingTouch(seekBar: SeekBar) {}
        })

        binding.matchNumber?.setOnClickListener {
            val matchEditable = binding.matchNumber
            if (matchEditable != null) {
                activeMatch.matchNumber = matchEditable.text.toString()
            }

            val getTeam = Thread {
                try {
                    val st = StringTokenizer(binding.scoutAssignment?.text.toString())
                    val allianceColor = st.nextToken().lowercase()
                    val allianceNum = Integer.parseInt(st.nextToken())

                    val matchData = JSONObject(URL(blueAllianceURL + activeMatch.matchNumber + blueAllianceAuthKey).readText())
                    activeMatch.teamNumber = (((((matchData.get("alliances") as JSONObject)
                            .get(allianceColor) as JSONObject)
                            .get("team_keys")) as JSONArray)
                            .get(allianceNum - 1) as String)
                            .substring(3)

                    binding.teamNumber?.setText(activeMatch.teamNumber.toString(), TextView.BufferType.EDITABLE)
                } catch(e : Exception) {
                    println("Cannot automatically update the team number")
                }
            }

            getTeam.start()
        }

        binding.teamNumber?.setOnClickListener {
            val teamEditable = binding.teamNumber
            if (teamEditable != null) {
                activeMatch.teamNumber = teamEditable.text.toString()
            }
        }

        binding.submit?.setOnClickListener {

            activeMatch.teamNumber = binding.teamNumber?.text.toString()
            activeMatch.matchNumber = binding.matchNumber?.text.toString()
            activeMatch.matchNotes = binding.matchNotes?.text.toString()
            activeMatch.scoutName = sharedPref.getString("scout_name", "Scout").toString()
            val database = context?.let { it1 -> AppDatabase.getDatabase(it1) }
            database?.matchDAO()?.insert(activeMatch)
            activeMatch = newMatch.copy()
            clearFields()
        }
        return root
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun clearFields() {
        binding.ampNoteAuto?.text = activeMatch.autoAmpCount.toString()
        binding.speakerNoteAuto?.text = activeMatch.autoSpeakerCount.toString()
        binding.ampNoteTeleOp?.text = activeMatch.teleopAmpCount.toString()
        binding.teleOpSpeaker?.text = activeMatch.teleOpSpeakerCount.toString()
        binding.leave?.isChecked = false
        binding.onStage?.isChecked = false
        binding.onStageSpotlit?.isChecked = false
        binding.trapNote?.isChecked = false
        binding.park?.isChecked = false
        binding.defense?.isChecked = false
        binding.disabledRobot?.isChecked = false
        binding.shootingDistanceBar?.progress = 0
        binding.matchNotes?.setText("", TextView.BufferType.EDITABLE)
        binding.teamNumber?.setText("", TextView.BufferType.EDITABLE)
        binding.matchNumber?.setText("", TextView.BufferType.EDITABLE)
    }

}