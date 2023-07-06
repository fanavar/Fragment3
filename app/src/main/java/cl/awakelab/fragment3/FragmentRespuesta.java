package cl.awakelab.fragment3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import cl.awakelab.fragment3.databinding.FragmentRespuestaBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentRespuesta#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRespuesta extends Fragment {

    private FragmentRespuestaBinding binding;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private boolean resultCorrect = false;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentRespuesta() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentRespuesta.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentRespuesta newInstance(String param1, String param2) {
        FragmentRespuesta fragment = new FragmentRespuesta();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            resultCorrect = getArguments().getBoolean("respuesta");

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentRespuestaBinding.inflate(getLayoutInflater(),
                container, false);
        if (resultCorrect == false){
            String resultCorrect = "incorrecta";
            binding.textViewRespuesta.setText( "respuesta " + resultCorrect);
        }else {
            String resultCorrect = "correcta";
            binding.textViewRespuesta.setText( "respuesta " + resultCorrect);
        }


        binding.buttonBack.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("nombre", mParam1);
            Navigation.findNavController(getView()).navigate(R.id.action_fragmentRespuesta_to_fragmentTrivia3, bundle);
        });

        return binding.getRoot();
    }
}