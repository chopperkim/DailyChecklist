package kr.co.pigland.dailychecklist

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.provider.MediaStore.ACTION_IMAGE_CAPTURE
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.camera.core.ImageCapture
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import kr.co.pigland.dailychecklist.databinding.FragmentFirstBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)

        RetrofitService.retrofit.checkContent().enqueue(object : Callback<List<CheckItem>> {
            override fun onResponse(
                call: Call<List<CheckItem>>,
                response: Response<List<CheckItem>>
            ) {
                if (response.isSuccessful) {
                    Log.d("FirstFragment", response.body().toString())
                    val checklist = response.body()
                    binding.recyclerView.adapter = checklist?.let { ChecklistAdapter(it) }
                }
            }

            override fun onFailure(call: Call<List<CheckItem>>, t: Throwable) {
                Log.e("FirstFragment", t.toString())
            }
        });

        binding.confirmButton.setOnClickListener {
            val intent = Intent(ACTION_IMAGE_CAPTURE)
            activity?.startActivity(intent)
        }

        return binding.root

    }

}