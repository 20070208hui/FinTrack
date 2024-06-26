package com.cashflow.fintrack.record_fragment;

import android.inputmethodservice.KeyboardView;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.cashflow.fintrack.R;

import utils.keyBoardUtils;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class OutcomeFragment extends Fragment {

    KeyboardView keyboardView;
    EditText moneyEt;
    ImageView typeIv;
    TextView typeTv, remarkTv, timeTv;
    GridView typeGv;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OutcomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OutcomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OutcomeFragment newInstance(String param1, String param2) {
        OutcomeFragment fragment = new OutcomeFragment();
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
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_outcome, container, false);
        initView(view);
        return view;
    }

    private void initView(View view){
        keyboardView = view.findViewById(R.id.frag_record_keyboard);
        moneyEt = view.findViewById(R.id.frag_record_et_money);
        typeIv = view.findViewById(R.id.frag_record_iv);
        typeGv = view.findViewById(R.id.frag_record_gv);
        typeTv = view.findViewById(R.id.frag_record_tv_type);
        remarkTv = view.findViewById(R.id.frag_record_tv_remark);
        timeTv = view.findViewById(R.id.frag_record_tv_time);
        //display keyboard

        keyBoardUtils boardUtils = new keyBoardUtils(keyboardView, moneyEt);
        boardUtils.showKeyboard();
        //设置接口，监听enter被点击
        boardUtils.setOnEnsureListener(new keyBoardUtils.OnEnsureListener() {
            @Override
            public void onEnsure() {
                //点击ensure
                //获取输入信息，保存进数据库，返回上一级页面
            }
        });
    }
}