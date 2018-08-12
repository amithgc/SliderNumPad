package amithgc.slidernumpad;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.DecimalFormat;

public class SliderNumPad extends BottomSheetDialogFragment {

    public static final String TAG = "SliderNumPad";
    public static Builder builder;
    private static final char ADDITION = '+';
    private static final char SUBTRACTION = '-';
    private static final char MULTIPLICATION = '*';
    private static final char DIVISION = '/';


    private static final int BUTTON_TYPE_CALCULATE = 0;
    private static final int BUTTON_TYPE_DONE = 1;


    private char CURRENT_ACTION;
    private DecimalFormat decimalFormat;
    private double valueOne = Double.NaN;
    private double valueTwo;
    private int equalButtonType = BUTTON_TYPE_DONE;


    private TextView result;
    private TextView infoTextView;
    private Button t1;
    private Button t2;
    private Button t3;
    private Button t4;
    private Button t5;
    private Button t6;
    private Button t7;
    private Button t8;
    private Button t9;
    private Button t0;
    private Button t000;
    private Button tDot;
    private Button tEnter;
    private Button tMinus;
    private Button tPlus;
    private Button tDelete;
    private Button tMultiply;
    private Button tDivide;
    private Button tCancel;

    private LinearLayout l1;
    private LinearLayout l2;
    private LinearLayout l3;
    private LinearLayout l4;
    private LinearLayout l5;
    private LinearLayout l6;
    private LinearLayout l7;
    private LinearLayout l8;
    private LinearLayout l9;
    private LinearLayout l0;
    private LinearLayout l000;
    private LinearLayout lDot;
    private LinearLayout lMinus;
    private LinearLayout lPlus;
    private LinearLayout lDelete;
    private LinearLayout lMultiply;
    private LinearLayout lDivide;
    private LinearLayout lCancel;
    private LinearLayout lEnter;

    View contentView;
    private BottomSheetBehavior.BottomSheetCallback mBottomSheetBehaviorCallback = new BottomSheetBehavior.BottomSheetCallback() {

        @Override
        public void onStateChanged(@NonNull View bottomSheet, int newState) {
            Log.d(TAG, "onStateChanged() newState: " + newState);
            if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                dismissAllowingStateLoss();
            }
        }

        @Override
        public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            Log.d(TAG, "onSlide() slideOffset: " + slideOffset);
        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void show(FragmentManager fragmentManager) {

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(this, getTag());
        ft.commitAllowingStateLoss();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Override
    public void onViewCreated(View contentView, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(contentView, savedInstanceState);
    }

    @Override
    public void setupDialog(Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        contentView = View.inflate(getContext(), R.layout.numpad_view, null);

        decimalFormat = new DecimalFormat("#.##########");

        result = contentView.findViewById(R.id.result);
        infoTextView = contentView.findViewById(R.id.infoTextView);
        t1 = contentView.findViewById(R.id.t1);
        t2 = contentView.findViewById(R.id.t2);
        t3 = contentView.findViewById(R.id.t3);
        t4 = contentView.findViewById(R.id.t4);
        t5 = contentView.findViewById(R.id.t5);
        t6 = contentView.findViewById(R.id.t6);
        t7 = contentView.findViewById(R.id.t7);
        t8 = contentView.findViewById(R.id.t8);
        t9 = contentView.findViewById(R.id.t9);
        t0 = contentView.findViewById(R.id.t0);
        t000 = contentView.findViewById(R.id.t000);
        tDot = contentView.findViewById(R.id.tDot);
        tEnter = contentView.findViewById(R.id.tEnter);
        tMinus = contentView.findViewById(R.id.tMinus);
        tPlus = contentView.findViewById(R.id.tPlus);
        tDelete = contentView.findViewById(R.id.tDelete);
        tMultiply = contentView.findViewById(R.id.tMultiply);
        tDivide = contentView.findViewById(R.id.tDivide);
        tCancel = contentView.findViewById(R.id.tCancel);

        lEnter = contentView.findViewById(R.id.lEnter);
        l1 = contentView.findViewById(R.id.l1);
        l2 = contentView.findViewById(R.id.l2);
        l3 = contentView.findViewById(R.id.l3);
        l4 = contentView.findViewById(R.id.l4);
        l5 = contentView.findViewById(R.id.l5);
        l6 = contentView.findViewById(R.id.l6);
        l7 = contentView.findViewById(R.id.l7);
        l8 = contentView.findViewById(R.id.l8);
        l9 = contentView.findViewById(R.id.l9);
        l0 = contentView.findViewById(R.id.l0);
        l000 = contentView.findViewById(R.id.l000);
        lDot = contentView.findViewById(R.id.lDot);
        lMinus = contentView.findViewById(R.id.lMinus);
        lPlus = contentView.findViewById(R.id.lPlus);
        lDelete = contentView.findViewById(R.id.lDelete);
        lMultiply = contentView.findViewById(R.id.lMultiply);
        lDivide = contentView.findViewById(R.id.lDivide);
        lCancel = contentView.findViewById(R.id.lCancel);


        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "1");
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "2");
            }
        });

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "3");
            }
        });

        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "4");
            }
        });

        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "5");
            }
        });

        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "6");
            }
        });

        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "7");
            }
        });

        t8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "8");
            }
        });

        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "9");
            }
        });

        t0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "0");
            }
        });

        t000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + "000");
            }
        });

        tDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result.setText(result.getText() + ".");
            }
        });

        tPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = ADDITION;
                infoTextView.setText(decimalFormat.format(valueOne) + "+");
                result.setText(null);

                equalButtonType = BUTTON_TYPE_CALCULATE;
                tEnter.setText("=");
                changeButtonColor(builder.getButtonEqualsBackgroundColor(), lEnter);
                changeTextColor(builder.getTextEqualsColor(), tEnter);
            }
        });

        tMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = SUBTRACTION;
                infoTextView.setText(decimalFormat.format(valueOne) + "-");
                result.setText(null);

                equalButtonType = BUTTON_TYPE_CALCULATE;
                tEnter.setText("=");
                changeButtonColor(builder.getButtonEqualsBackgroundColor(), lEnter);
                changeTextColor(builder.getTextEqualsColor(), tEnter);
            }
        });

        tMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = MULTIPLICATION;
                infoTextView.setText(decimalFormat.format(valueOne) + "*");
                result.setText(null);

                equalButtonType = BUTTON_TYPE_CALCULATE;
                tEnter.setText("=");
                changeButtonColor(builder.getButtonEqualsBackgroundColor(), lEnter);
                changeTextColor(builder.getTextEqualsColor(), tEnter);
            }
        });

        tDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                CURRENT_ACTION = DIVISION;
                infoTextView.setText(decimalFormat.format(valueOne) + "/");
                result.setText(null);

                equalButtonType = BUTTON_TYPE_CALCULATE;
                tEnter.setText("=");
                changeButtonColor(builder.getButtonEqualsBackgroundColor(), lEnter);
                changeTextColor(builder.getTextEqualsColor(), tEnter);
            }
        });

        tDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (result.getText().length() > 0) {
                    CharSequence currentText = result.getText();
                    result.setText(currentText.subSequence(0, currentText.length() - 1));
                } else {
                    valueOne = Double.NaN;
                    valueTwo = Double.NaN;
                    result.setText("");
                    infoTextView.setText("");
                }
            }
        });

        tCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valueOne = Double.NaN;
                valueTwo = Double.NaN;
                result.setText("");
                infoTextView.setText("");
            }
        });

        tEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                computeCalculation();
                infoTextView.setText(infoTextView.getText().toString() +
                        decimalFormat.format(valueTwo) + " = " + decimalFormat.format(valueOne));
                result.setText(decimalFormat.format(valueOne));
                valueOne = Double.NaN;
                CURRENT_ACTION = '0';

                if (equalButtonType == BUTTON_TYPE_DONE) {
                    dismissAllowingStateLoss();
                }

                equalButtonType = BUTTON_TYPE_DONE;
                tEnter.setText(">");
                changeButtonColor(builder.getButtonSubmitBackgroundColor(), lEnter);
                changeTextColor(builder.getTextSubmitColor(), tEnter);
            }
        });

        changeButtonColor(builder.getButtonBackgroundColor(), lEnter);
        changeButtonColor(builder.getButtonSubmitBackgroundColor(), lEnter);
        changeButtonColor(builder.getButtonBackgroundColor(), l1, l2, l3, l4, l5, l6, l7, l8, l9,
                l0, l000, lDot, lMinus, lPlus, lDelete, lMultiply, lDivide, lCancel);

        changeTextColor(builder.getTextColor(), tEnter);
        changeTextColor(builder.getTextSubmitColor(), tEnter);
        changeTextColor(builder.getTextColor(), t1, t2, t3, t4, t5, t6, t7, t8, t9,
                t0, t000, tDot, tMinus, tPlus, tDelete, tMultiply, tDivide, tCancel);
        changeButtonTextSize(builder.getTextSize(), t1, t2, t3, t4, t5, t6, t7, t8, t9,
                t0, t000, tDot, tMinus, tPlus, tDelete, tMultiply, tDivide, tCancel, tEnter);
        changeButtonTextStyle(builder.getTextStyle(), t1, t2, t3, t4, t5, t6, t7, t8, t9,
                t0, t000, tDot, tMinus, tPlus, tDelete, tMultiply, tDivide, tCancel, tEnter);

        dialog.setContentView(contentView);
    }

    private void changeButtonColor(String color, LinearLayout... buttons) {

        for (LinearLayout button : buttons) {
            try {
                if (color != null) {
                    GradientDrawable background = (GradientDrawable) button.getBackground();
                    background.setColor(Color.parseColor(color));
                    button.refreshDrawableState();
                }
            } catch (Exception ignored) {
                ignored.printStackTrace();
            }
        }
    }

    private void changeTextColor(String color, Button... buttons) {

        for (Button button : buttons) {
            try {
                if (color != null) {
                    button.setTextColor(Color.parseColor(color));
                }
            } catch (Exception ignored) {
                ignored.printStackTrace();
            }
        }
    }

    private void changeButtonTextSize(float size, Button... buttons) {

        for (Button button : buttons) {
            try {
                if (size > 0) {
                    button.setTextSize(size);
                }
            } catch (Exception ignored) {
                ignored.printStackTrace();
            }
        }
    }

    private void changeButtonTextStyle(int style, Button... buttons) {

        for (Button button : buttons) {
            try {
                if (style != -1) {
                    button.setTypeface(button.getTypeface(), style);
                }
            } catch (Exception ignored) {
                ignored.printStackTrace();
            }
        }
    }

    private void computeCalculation() {
        if (!Double.isNaN(valueOne)) {
            try {
                valueTwo = Double.parseDouble(result.getText().toString());
                result.setText(null);

                if (CURRENT_ACTION == ADDITION)
                    valueOne = this.valueOne + valueTwo;
                else if (CURRENT_ACTION == SUBTRACTION)
                    valueOne = this.valueOne - valueTwo;
                else if (CURRENT_ACTION == MULTIPLICATION)
                    valueOne = this.valueOne * valueTwo;
                else if (CURRENT_ACTION == DIVISION)
                    valueOne = this.valueOne / valueTwo;
            } catch (Exception e) {
                result.setText(decimalFormat.format(valueOne));
            }
        } else {
            try {
                valueOne = Double.parseDouble(result.getText().toString());
            } catch (Exception e) {
            }
        }
    }

    public interface OnTextInputFinishListener {
        void onTextSelected(Uri uri);
    }

    public static class Builder {

        Context context;
        String buttonBackgroundColor = null;
        String buttonEqualsBackgroundColor = null;
        String buttonSubmitBackgroundColor = null;
        String textColor = null;
        String textEqualsColor = null;
        String textSubmitColor = null;
        float textSize = -1;
        int textStyle = -1;
        OnTextInputFinishListener onTextSelectedListener;

        public Builder(@NonNull Context context) {
            this.context = context;
        }

        public Builder setButtonBackgroundColor(String buttonBackgroundColor) {
            this.buttonBackgroundColor = buttonBackgroundColor;
            return this;
        }

        public String getButtonBackgroundColor() {
            return buttonBackgroundColor;
        }

        public Builder setOnTextSelectedListener(OnTextInputFinishListener onTextSelectedListener) {
            this.onTextSelectedListener = onTextSelectedListener;
            return this;
        }

        public SliderNumPad create() {
            if (onTextSelectedListener == null) {
                throw new RuntimeException("onTextSelectedListener is not defined.");
            }

            SliderNumPad customSheetDialogFragment = new SliderNumPad();
            builder = this;
            return customSheetDialogFragment;
        }

        public String getButtonEqualsBackgroundColor() {
            return buttonEqualsBackgroundColor;
        }

        public Builder setButtonEqualsBackgroundColor(String buttonEqualsBackgroundColor) {
            this.buttonEqualsBackgroundColor = buttonEqualsBackgroundColor;
            return this;
        }

        public String getButtonSubmitBackgroundColor() {
            return buttonSubmitBackgroundColor;
        }

        public Builder setButtonSubmitBackgroundColor(String buttonSubmitBackgroundColor) {
            this.buttonSubmitBackgroundColor = buttonSubmitBackgroundColor;
            return this;
        }

        public String getTextColor() {
            return textColor;
        }

        public Builder setTextColor(String textColor) {
            this.textColor = textColor;
            return this;
        }

        public String getTextEqualsColor() {
            return textEqualsColor;
        }

        public Builder setTextEqualsColor(String textEqualsColor) {
            this.textEqualsColor = textEqualsColor;
            return this;
        }

        public String getTextSubmitColor() {
            return textSubmitColor;
        }

        public Builder setTextSubmitColor(String textSubmitColor) {
            this.textSubmitColor = textSubmitColor;
            return this;
        }

        public float getTextSize() {
            return textSize;
        }

        public Builder setTextSize(float textSize) {
            this.textSize = textSize;
            return this;
        }

        public int getTextStyle() {
            return textStyle;
        }

        public Builder setTextStyle(int textStyle) {
            this.textStyle = textStyle;
            return this;
        }
    }


}
