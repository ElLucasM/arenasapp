package com.example.arenas;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MapNavigation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //obligatorio start
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_navigation);
        setBackAsBack();

        //FULL SCREEN
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        //DECLARO BOTON
        final Button buttonsolar1 = findViewById(R.id.buttonsolar1);
        final Button buttonsolar2 = findViewById(R.id.buttonsolar2);
        final Button buttonsolar3 = findViewById(R.id.buttonsolar3);
        final Button buttonsolar4 = findViewById(R.id.buttonsolar4);
        final Button buttonsolar5 = findViewById(R.id.buttonsolar5);
        final Button buttonsolar6 = findViewById(R.id.buttonsolar6);
        final Button buttonsolar7 = findViewById(R.id.buttonsolar7);
        final Button buttonsolar8 = findViewById(R.id.buttonsolar8);
        final Button buttonsolar9 = findViewById(R.id.buttonsolar9);
        final Button buttonsolar10 = findViewById(R.id.buttonsolar10);
        final Button buttonsolar11 = findViewById(R.id.buttonsolar11);
        final Button buttonsolar12 = findViewById(R.id.buttonsolar12);
        final Button buttonsolar13 = findViewById(R.id.buttonsolar13);
        final Button buttonsolar14 = findViewById(R.id.buttonsolar14);
        final Button buttonsolar15 = findViewById(R.id.buttonsolar15);
        final Button buttonsolar16 = findViewById(R.id.buttonsolar16);
        final Button buttonsolar17 = findViewById(R.id.buttonsolar17);
        final Button buttonsolar18 = findViewById(R.id.buttonsolar18);
        final Button buttonsolar19 = findViewById(R.id.buttonsolar19);
        final Button buttonsolar20 = findViewById(R.id.buttonsolar20);
        final Button buttonsolar21 = findViewById(R.id.buttonsolar21);
        final Button buttonsolar22 = findViewById(R.id.buttonsolar22);

        final FloatingActionButton back = findViewById(R.id.back);

        final Button[] buttons = new Button[22];
        buttons[0] = buttonsolar1;
        buttons[1] = buttonsolar2;
        buttons[2] = buttonsolar3;
        buttons[3] = buttonsolar4;
        buttons[4] = buttonsolar5;
        buttons[5] = buttonsolar6;
        buttons[6] = buttonsolar7;
        buttons[7] = buttonsolar8;
        buttons[8] = buttonsolar9;
        buttons[9] = buttonsolar10;
        buttons[10] = buttonsolar11;
        buttons[11] = buttonsolar12;
        buttons[12] = buttonsolar13;
        buttons[13] = buttonsolar14;
        buttons[14] = buttonsolar15;
        buttons[15] = buttonsolar16;
        buttons[16] = buttonsolar17;
        buttons[17] = buttonsolar18;
        buttons[18] = buttonsolar19;
        buttons[19] = buttonsolar20;
        buttons[20] = buttonsolar21;
        buttons[21] = buttonsolar22;

        //SET EVENTO
        ObjectAnimator fadeInBack = ObjectAnimator.ofFloat(back, "translationX", 0f);
        fadeInBack.setDuration(250);
        fadeInBack.start();

        buttonsolar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveMap(buttonsolar1, view);
                hideButtons(buttons);
                final FloatingActionButton back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resetMap();
                        showButtons(buttons);
                        setBackAsBack();
                    }
                });
            }
        });

        buttonsolar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveMap(buttonsolar2, view);
                hideButtons(buttons);
                final FloatingActionButton back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resetMap();
                        showButtons(buttons);
                        setBackAsBack();
                    }
                });
            }
        });

        buttonsolar3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveMap(buttonsolar3, view);
                hideButtons(buttons);
                final FloatingActionButton back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resetMap();
                        showButtons(buttons);
                        setBackAsBack();
                    }
                });
            }
        });


        buttonsolar4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveMap(buttonsolar4, view);
                hideButtons(buttons);
                final FloatingActionButton back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resetMap();
                        showButtons(buttons);
                        setBackAsBack();
                    }
                });
            }
        });

        buttonsolar5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveMap(buttonsolar5, view);
                hideButtons(buttons);
                final FloatingActionButton back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resetMap();
                        showButtons(buttons);
                        setBackAsBack();
                    }
                });
            }
        });

        buttonsolar6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveMap(buttonsolar6, view);
                hideButtons(buttons);
                final FloatingActionButton back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resetMap();
                        showButtons(buttons);
                        setBackAsBack();
                    }
                });
            }
        });

        buttonsolar7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveMap(buttonsolar7, view);
                hideButtons(buttons);
                final FloatingActionButton back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resetMap();
                        showButtons(buttons);
                        setBackAsBack();
                    }
                });
            }
        });

        buttonsolar8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveMap(buttonsolar8, view);
                hideButtons(buttons);
                final FloatingActionButton back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resetMap();
                        showButtons(buttons);
                        setBackAsBack();
                    }
                });
            }
        });

        buttonsolar9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveMap(buttonsolar9, view);
                hideButtons(buttons);
                final FloatingActionButton back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resetMap();
                        showButtons(buttons);
                        setBackAsBack();
                    }
                });
            }
        });

        buttonsolar10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveMap(buttonsolar10, view);
                hideButtons(buttons);
                final FloatingActionButton back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resetMap();
                        showButtons(buttons);
                        setBackAsBack();
                    }
                });
            }
        });

        buttonsolar11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveMap(buttonsolar11, view);
                hideButtons(buttons);
                final FloatingActionButton back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resetMap();
                        showButtons(buttons);
                        setBackAsBack();
                    }
                });
            }
        });

        buttonsolar12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveMap(buttonsolar12, view);
                hideButtons(buttons);
                final FloatingActionButton back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resetMap();
                        showButtons(buttons);
                        setBackAsBack();
                    }
                });
            }
        });

        buttonsolar13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveMap(buttonsolar13, view);
                hideButtons(buttons);
                final FloatingActionButton back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resetMap();
                        showButtons(buttons);
                        setBackAsBack();
                    }
                });
            }
        });

        buttonsolar14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveMap(buttonsolar14, view);
                hideButtons(buttons);
                final FloatingActionButton back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resetMap();
                        showButtons(buttons);
                        setBackAsBack();
                    }
                });
            }
        });

        buttonsolar15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveMap(buttonsolar15, view);
                hideButtons(buttons);
                final FloatingActionButton back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resetMap();
                        showButtons(buttons);
                        setBackAsBack();
                    }
                });
            }
        });

        buttonsolar16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveMap(buttonsolar16, view);
                hideButtons(buttons);
                final FloatingActionButton back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resetMap();
                        showButtons(buttons);
                        setBackAsBack();
                    }
                });
            }
        });

        buttonsolar16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveMap(buttonsolar16, view);
                hideButtons(buttons);
                final FloatingActionButton back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resetMap();
                        showButtons(buttons);
                        setBackAsBack();
                    }
                });
            }
        });

        buttonsolar17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveMap(buttonsolar17, view);
                hideButtons(buttons);
                final FloatingActionButton back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resetMap();
                        showButtons(buttons);
                        setBackAsBack();
                    }
                });
            }
        });

        buttonsolar18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveMap(buttonsolar18, view);
                hideButtons(buttons);
                final FloatingActionButton back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resetMap();
                        showButtons(buttons);
                        setBackAsBack();
                    }
                });
            }
        });

        buttonsolar19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveMap(buttonsolar19, view);
                hideButtons(buttons);
                final FloatingActionButton back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resetMap();
                        showButtons(buttons);
                        setBackAsBack();
                    }
                });
            }
        });

        buttonsolar20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveMap(buttonsolar20, view);
                hideButtons(buttons);
                final FloatingActionButton back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resetMap();
                        showButtons(buttons);
                        setBackAsBack();
                    }
                });
            }
        });

        buttonsolar21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveMap(buttonsolar21, view);
                hideButtons(buttons);
                final FloatingActionButton back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resetMap();
                        showButtons(buttons);
                        setBackAsBack();
                    }
                });
            }
        });

        buttonsolar22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveMap(buttonsolar22, view);
                hideButtons(buttons);
                final FloatingActionButton back = findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        resetMap();
                        showButtons(buttons);
                        setBackAsBack();
                    }
                });
            }
        });


    }

    private void moveMap(Button button, View view){
        int[] location = new int[2];
        button.getLocationInWindow(location);
        int x = location[0] + view.getWidth() / 2;
        int y = location[1] + view.getHeight() / 2;
        float newScale = 3.5f;
        float newX = x*-3.5f+2100;
        float newY = y*-3.5f+1300;
        ObjectAnimator setTerreno0X = ObjectAnimator.ofFloat(findViewById(R.id.map), "translationX", newX);
        setTerreno0X.setDuration(500);
        ObjectAnimator setTerreno0Y = ObjectAnimator.ofFloat(findViewById(R.id.map), "translationY", newY);
        setTerreno0Y.setDuration(500);
        ObjectAnimator setTerreno0Zx = ObjectAnimator.ofFloat(findViewById(R.id.map), "scaleX", newScale);
        setTerreno0Zx.setDuration(500);
        ObjectAnimator setTerreno0Zy = ObjectAnimator.ofFloat(findViewById(R.id.map), "scaleY", newScale);
        setTerreno0Zy.setDuration(500);
        AnimatorSet zoomInTerreno0 = new AnimatorSet();
        zoomInTerreno0.playTogether(setTerreno0X,setTerreno0Y,setTerreno0Zx,setTerreno0Zy);
        zoomInTerreno0.start();
    }

    private void resetMap(){
        ObjectAnimator setTerreno0X = ObjectAnimator.ofFloat(findViewById(R.id.map), "translationX", 0f);
        setTerreno0X.setDuration(500);
        ObjectAnimator setTerreno0Y = ObjectAnimator.ofFloat(findViewById(R.id.map), "translationY", 0f);
        setTerreno0Y.setDuration(500);
        ObjectAnimator setTerreno0Zx = ObjectAnimator.ofFloat(findViewById(R.id.map), "scaleX", 1f);
        setTerreno0Zx.setDuration(500);
        ObjectAnimator setTerreno0Zy = ObjectAnimator.ofFloat(findViewById(R.id.map), "scaleY", 1f);
        setTerreno0Zy.setDuration(500);
        AnimatorSet zoomInTerreno0 = new AnimatorSet();
        zoomInTerreno0.playTogether(setTerreno0X,setTerreno0Y,setTerreno0Zx,setTerreno0Zy);
        zoomInTerreno0.start();
    }

    private void setBackAsBack(){
        Intent i = new Intent(this, MainActivity.class);
        final FloatingActionButton back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(i);
            }
        });
    }

    private void hideButtons(Button[] buttons) {
        for (int i = 0;i < buttons.length;i++) {
            hideButton(buttons[i]);
        }
    }

    private void showButtons(Button[] buttons) {
        for (int i = 0;i < buttons.length;i++) {
            showButton(buttons[i]);
        }
    }

    private void hideButton(Button button){
        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(findViewById(button.getId()),"alpha",0f);
        fadeOut.setDuration(100);
        fadeOut.start();
        button.setEnabled(false);
    }

    private void showButton(Button button){
        ObjectAnimator fadeOut = ObjectAnimator.ofFloat(findViewById(button.getId()),"alpha",1f);
        fadeOut.setDuration(100);
        fadeOut.setStartDelay(400);
        fadeOut.start();
        button.setEnabled(true);
    }

}