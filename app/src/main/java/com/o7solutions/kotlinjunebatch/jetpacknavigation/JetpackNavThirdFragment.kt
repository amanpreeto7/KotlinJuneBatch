package com.o7solutions.kotlinjunebatch.jetpacknavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.o7solutions.kotlinjunebatch.R
import com.o7solutions.kotlinjunebatch.databinding.FragmentJetpackNavSecondBinding

/**
 * A simple [Fragment] subclass.
 * Use the [JetpackNavThirdFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class JetpackNavThirdFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentJetpackNavSecondBinding
    lateinit var jetpackActivity: JetpackActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        jetpackActivity = activity as JetpackActivity

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentJetpackNavSecondBinding.inflate(layoutInflater)
        arguments?.let {
            var name = it.getString("name1")
            binding.tvName.setText("Your name $name")
            System.out.println("name = $name")
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvName.setText("Third Fragment")
        binding.btnPop.setOnClickListener {
            jetpackActivity.navController.popBackStack()
        }

        binding.btnNavigate.setOnClickListener {
            jetpackActivity.navController.navigate(R.id.action_jetpackNavThirdFragment_to_jetpackNavFourthFragment)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment JetpackNavSecondFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            JetpackNavThirdFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}