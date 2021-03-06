package manuele.bryan.derivagral;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class SolutionDialog extends DialogFragment {

    public static final String FUNCTION_BUNDLE_KEY = "function";
    public static final String DERIVATIVE_BUNDLE_KEY = "derivative";
    public static final String INTEGRAL_BUNDLE_KEY = "integral";

    private Context context;

    private TextView functionTextView;
    private TextView derivativeTextView;
    private TextView integralTextView;

    public String function;
    public String derivative;
    public String integral;

    public static SolutionDialog newInstance(String function, String derivative, String integral) {
        SolutionDialog solutionDialog = new SolutionDialog();

        Bundle bundle = new Bundle();
        bundle.putString(FUNCTION_BUNDLE_KEY, function);
        bundle.putString(DERIVATIVE_BUNDLE_KEY, derivative);
        bundle.putString(INTEGRAL_BUNDLE_KEY, integral);
        solutionDialog.setArguments(bundle);

        return solutionDialog;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        super.onCreateDialog(savedInstanceState);
        function = getArguments().getString(FUNCTION_BUNDLE_KEY);
        derivative = getArguments().getString(DERIVATIVE_BUNDLE_KEY);
        integral = getArguments().getString(INTEGRAL_BUNDLE_KEY);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.alert_solution, null);

        functionTextView = (TextView) view.findViewById(R.id.functionTextView);
        derivativeTextView = (TextView) view.findViewById(R.id.derivativeTextView);
        integralTextView = (TextView) view.findViewById(R.id.integralTextView);

        functionTextView.setText(function);
        derivativeTextView.setText(derivative);
        integralTextView.setText(integral);

        builder.setView(view);
        return builder.create();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        context = activity;
    }

}
