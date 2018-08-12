package amithgc.slidernumpad;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
            }
        });

        dialog.setContentView(contentView);
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
        Drawable cameraTileDrawable;
        Drawable galleryTileDrawable;

        int spacing = 1;
        OnTextInputFinishListener onTextSelectedListener;

        public String title;
        public boolean showTitle = true;

        public Builder(@NonNull Context context) {

            this.context = context;

//            setCameraTile(R.drawable.ic_camera);
//            setGalleryTile(R.drawable.ic_gallery);
//            setSpacingResId(R.dimen.tedbottompicker_grid_layout_margin);
        }

        public Builder setCameraTile(@DrawableRes int cameraTileResId) {
            setCameraTile(ContextCompat.getDrawable(context, cameraTileResId));
            return this;
        }

        public Builder setGalleryTile(@DrawableRes int galleryTileResId) {
            setGalleryTile(ContextCompat.getDrawable(context, galleryTileResId));
            return this;
        }

        public Builder setSpacingResId(@DimenRes int dimenResId) {
            this.spacing = context.getResources().getDimensionPixelSize(dimenResId);
            return this;
        }

        public Builder setCameraTile(Drawable cameraTileDrawable) {
            this.cameraTileDrawable = cameraTileDrawable;
            return this;
        }

        public Builder setGalleryTile(Drawable galleryTileDrawable) {
            this.galleryTileDrawable = galleryTileDrawable;
            return this;
        }

        public Builder setOnTextSelectedListener(OnTextInputFinishListener onTextSelectedListener) {
            this.onTextSelectedListener = onTextSelectedListener;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setTitle(@StringRes int stringResId) {
            this.title = context.getResources().getString(stringResId);
            return this;
        }

        public Builder showTitle(boolean showTitle) {
            this.showTitle = showTitle;
            return this;
        }

        public SliderNumPad create() {
            if (onTextSelectedListener == null) {
                throw new RuntimeException("onTextSelectedListener is not defined.");
            }

            SliderNumPad customBottomSheetDialogFragment = new SliderNumPad();

            customBottomSheetDialogFragment.builder = this;
            return customBottomSheetDialogFragment;
        }

    }


}
