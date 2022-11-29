package com.mdp.cvbuilderapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_contact.*


/**
 * A simple [Fragment] subclass.
 * Use the [ContactFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ContactFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cardEmail.setOnClickListener{
            onEmailClicked(getString(R.string.contact_email))
        }

        cardPhone.setOnClickListener{
            onPhoneClicked(getString(R.string.contact_phone))
        }

        cardLinkedIn.setOnClickListener{
            onOpenWeb(getString(R.string.contact_linkedIn))
        }

        cardGithub.setOnClickListener{
            onOpenWeb(getString(R.string.contact_github))
        }
    }

    private fun onPhoneClicked(phone: String){
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse(phone)
        startActivity(intent)
    }

    private fun onEmailClicked(email: String){
        val intent = Intent(Intent.ACTION_SEND)
        intent.data = Uri.parse("mailto:")
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
        startActivity(intent)
    }

    private fun onOpenWeb(url: String){
        val intent = Intent(context, WebActivity::class.java)
        intent.putExtra("url", url)
        startActivity(intent)
    }
}