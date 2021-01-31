package com.example.example_sqlite.ui.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.example_sqlite.R
import com.example.example_sqlite.model.User
import com.example.example_sqlite.ui.activitys.MainActivity
import kotlinx.android.synthetic.main.fragment_add_user.*
import java.lang.Exception

class AddUserFragment : Fragment(R.layout.fragment_add_user) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonCreate.setOnClickListener {
            create()
        }
    }

    private fun create() {
        try {
            val activity = (requireActivity() as MainActivity)

            val user = User()
            user.name = editTextName.text.toString()
            user.email = editTextEmail.text.toString()

            activity.viewModel.save(user)
            Toast.makeText(activity, R.string.success, Toast.LENGTH_LONG).show()

        } catch (e: Exception) {
            Toast.makeText(activity, R.string.erro, Toast.LENGTH_LONG).show()
        }
    }
}