package br.com.joinersa.oooalertdialog;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Joiner on 04/06/18.
 */

public class OoOAlertDialog {

    private String title, message, positiveButtonText, negativeButtonText;
    private Activity activity;
    private int image;
    private Animation animation;
    private OnClickListener positiveButtonListener, negativeButtonListener;
    private int positiveButtonColor, negativeButtonColor, backgroundColor;
    private boolean cancelable;

    public OoOAlertDialog(Builder builder) {
        this.title = builder.title;
        this.message = builder.message;
        this.positiveButtonText = builder.positiveButtonText;
        this.negativeButtonText = builder.negativeButtonText;
        this.activity = builder.activity;
        this.image = builder.image;
        this.animation = builder.animation;
        this.positiveButtonListener = builder.positiveButtonListener;
        this.negativeButtonListener = builder.negativeButtonListener;
        this.positiveButtonColor = builder.positiveButtonColor;
        this.negativeButtonColor = builder.negativeButtonColor;
        this.backgroundColor = builder.backgroundColor;
        this.cancelable = builder.cancelable;
    }

    public static class Builder {
        private String title, message, positiveButtonText, negativeButtonText;
        private Activity activity;
        private int image;
        private Animation animation;
        private OnClickListener positiveButtonListener, negativeButtonListener;
        private int positiveButtonColor, negativeButtonColor, backgroundColor;
        private boolean cancelable = true;

        public Builder(Activity activity) {
            this.activity = activity;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setMessage(String message) {
            this.message = message;
            return this;
        }

        public Builder setPositiveButton(String positiveButtonText, OnClickListener positiveButtonListener) {
            this.positiveButtonText = positiveButtonText;
            this.positiveButtonListener = positiveButtonListener;
            return this;
        }

        public Builder setNegativeButton(String negativeButtonText, OnClickListener negativeButtonListener) {
            this.negativeButtonText = negativeButtonText;
            this.negativeButtonListener = negativeButtonListener;
            return this;
        }

        public Builder setImage(int image) {
            this.image = image;
            return this;
        }

        public Builder setAnimation(Animation animation) {
            this.animation = animation;
            return this;
        }

        public Builder setPositiveButtonColor(int positiveButtonColor) {
            this.positiveButtonColor = positiveButtonColor;
            return this;
        }

        public Builder setNegativeButtonColor(int negativeButtonColor) {
            this.negativeButtonColor = negativeButtonColor;
            return this;
        }

        public Builder setBackgroundColor(int backgroundColor) {
            this.backgroundColor = backgroundColor;
            return this;
        }

        public Builder setCancelable(boolean cancelable) {
            this.cancelable = cancelable;
            return this;
        }

        public OoOAlertDialog build() {
            TextView tvMessage, tvTitle;
            ImageView ivImage;
            AppCompatButton btNegative, btPositive;
            View viewSeparator;
            final Dialog dialog;
            LinearLayout llButtons;
            CardView cvBackgroundAlertdialog;

            // Instancia Dialog e seta o tema com a animação caso haja.
            if (animation == Animation.POP) {
                dialog = new Dialog(activity, R.style.PopTheme);
            } else if (animation == Animation.SIDE) {
                dialog = new Dialog(activity, R.style.SideTheme);
            } else if (animation == Animation.SLIDE) {
                dialog = new Dialog(activity, R.style.SlideTheme);
            } else {
                dialog = new Dialog(activity);
            }

            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.setCancelable(cancelable);
            dialog.setContentView(R.layout.layout_oooalertdialog);

            viewSeparator = dialog.findViewById(R.id.v_separator);
            tvTitle = dialog.findViewById(R.id.tv_title);
            tvMessage = dialog.findViewById(R.id.tv_message);
            ivImage = dialog.findViewById(R.id.iv_image);
            btNegative = dialog.findViewById(R.id.bt_negative);
            btPositive = dialog.findViewById(R.id.bt_positive);
            cvBackgroundAlertdialog = dialog.findViewById(R.id.cv_background_alertdialog); // referencia para CardView
            llButtons = dialog.findViewById(R.id.ll_buttons);

            // Verifica mensagem
            if (message != null) {
                // Verifica mais uma vez porque com o && iria verificar se a straing seria vazia através do equals().
                // Dessa forma só verifica se o objeto existir. Evitando NullPointerException
                if (!message.equals("")) {
                    tvMessage.setVisibility(View.VISIBLE);
                    tvMessage.setText(message);
                } else {
                    tvMessage.setVisibility(View.GONE);
                }

            } else {
                tvMessage.setVisibility(View.GONE);
            }

            // Verifica titulo
            if (title != null) {
                // Verifica mais uma vez porque com o && iria verificar se a straing seria vazia através do equals().
                // Dessa forma só verifica se o objeto existir. Evitando NullPointerException
                if (!title.equals("")) {
                    viewSeparator.setVisibility(View.VISIBLE);
                    tvTitle.setVisibility(View.VISIBLE);
                    tvTitle.setText(title);
                } else {
                    viewSeparator.setVisibility(View.GONE);
                    tvTitle.setVisibility(View.GONE);
                }
            } else {
                viewSeparator.setVisibility(View.GONE);
                tvTitle.setVisibility(View.GONE);
            }

            // Verificação para esconder layout dos botões
            if (positiveButtonText != null || negativeButtonText != null) {

                llButtons.setVisibility(View.VISIBLE);

                // Verifica o texto do botão, ele define se existe o botão
                if (positiveButtonText != null) {

                    if (!positiveButtonText.equals("")) {

                        btPositive.setVisibility(View.VISIBLE);
                        btPositive.setText(positiveButtonText);

                        // Verifica a COR
                        if (positiveButtonColor != 0) {
                            GradientDrawable bgShape = (GradientDrawable) btPositive.getBackground();
                            bgShape.setColor(positiveButtonColor);
                        }

                        // Verifica o LISTENER
                        if (positiveButtonListener != null) {
                            btPositive.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    positiveButtonListener.onClick();
                                    dialog.dismiss();
                                }
                            });
                        } else {
                            btPositive.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog.dismiss();
                                }
                            });
                        }
                    } else {
                        btPositive.setVisibility(View.GONE); // invisivel sem espaço
                    }

                } else {
                    btPositive.setVisibility(View.GONE); // invisivel sem espaço
                }

                // Verifica o texto do botão, ele define se existe o botão
                if (negativeButtonText != null) {

                    if (!negativeButtonText.equals("")) {

                        btNegative.setVisibility(View.VISIBLE);
                        btNegative.setText(negativeButtonText);

                        // Verifica a COR
                        if (negativeButtonColor != 0) {
                            GradientDrawable bgShape = (GradientDrawable) btNegative.getBackground();
                            bgShape.setColor(negativeButtonColor);
                        }

                        // Verifica o LISTENER
                        if (negativeButtonListener != null) {

                            btNegative.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    negativeButtonListener.onClick();
                                    dialog.dismiss();
                                }
                            });
                        } else {

                            btNegative.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    dialog.dismiss();
                                }
                            });
                        }
                    } else {
                        btNegative.setVisibility(View.GONE);
                    }

                } else {
                    btNegative.setVisibility(View.GONE);
                }

            } else {

                llButtons.setVisibility(View.GONE);

            }


            if (image != 0) {

                ivImage.setImageResource(image);
                ivImage.setVisibility(View.VISIBLE);

            } else {
                ivImage.setVisibility(View.GONE);
            }


            if (backgroundColor != 0) {
                cvBackgroundAlertdialog.setCardBackgroundColor(backgroundColor); // setar background modificado
            }


            dialog.show();

            return new OoOAlertDialog(this);

        }

    }
}
