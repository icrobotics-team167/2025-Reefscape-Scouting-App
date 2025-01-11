package com.example.cotcscouting
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.cotcscouting.databinding.FragmentLoginBinding


class LoginFragment : DialogFragment() {
    private var _binding: FragmentLoginBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater
            _binding = FragmentLoginBinding.inflate(inflater)
            val root: ViewGroup = binding.root
            builder.setTitle("Login to Start Scouting")
            builder.setView(root)
                .setPositiveButton("Login") { _, _ ->
                    val sharedPref = requireActivity().getPreferences(Context.MODE_PRIVATE)
                    val editor = sharedPref.edit()
                    editor.putString("scout_name", binding.username.text.toString())
                    editor.putString("scout_assignment", binding.assignedScout.text.toString())
                    editor.apply()
                   }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }
}