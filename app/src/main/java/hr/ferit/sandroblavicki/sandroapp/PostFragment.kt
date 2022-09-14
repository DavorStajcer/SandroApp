package hr.ferit.sandroblavicki.sandroapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import hr.ferit.sandroblavicki.sandroapp.databinding.PostFramentBinding


class PostFragment : Fragment() {

    private lateinit var binding: PostFramentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = PostFramentBinding.inflate(LayoutInflater.from(context),container,false)
        return binding.root
    }


}