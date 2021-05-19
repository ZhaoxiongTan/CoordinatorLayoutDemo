package tech.tanzx.coordinatorlayoutdemo.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import tech.tanzx.coordinatorlayoutdemo.databinding.FragmentRecyclerBinding

/**
 * A simple [Fragment] subclass.
 * Use the [RecyclerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecyclerFragment : Fragment() {

    private lateinit var binding: FragmentRecyclerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentRecyclerBinding.inflate(inflater, container, false)

        return binding.root
    }

    companion object {
        private const val TAG = "RecyclerFragment"
    }
}