package com.example.easytolearn.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.easytolearn.R;
import com.example.easytolearn.Responses.GetBookmarkModelView;
import com.example.easytolearn.adapter.TabPagerAdapter;
import com.example.easytolearn.adapter.TapPagerAdapterNew;
import com.example.easytolearn.databinding.ActivityBookMarkDetailsBinding;

import java.util.ArrayList;

public class BookMarkDetails extends AppCompatActivity implements View.OnClickListener {
    ActivityBookMarkDetailsBinding binding;
    String subName = "";
    ArrayList<GetBookmarkModelView.ResponseBean> bookmarkedList;
    ArrayList<GetBookmarkModelView.ResponseBean> mathVideoList;
    ArrayList<GetBookmarkModelView.ResponseBean> mathConceptList;
    ArrayList<GetBookmarkModelView.ResponseBean> mathQuestionList;
    ArrayList<GetBookmarkModelView.ResponseBean> chemVideoList;
    ArrayList<GetBookmarkModelView.ResponseBean> chemConceptList;
    ArrayList<GetBookmarkModelView.ResponseBean> chemQuestionList;
    ArrayList<GetBookmarkModelView.ResponseBean> phyVideoList;
    ArrayList<GetBookmarkModelView.ResponseBean> phyConceptList;
    ArrayList<GetBookmarkModelView.ResponseBean> phyQuestionList;
    ArrayList<GetBookmarkModelView.ResponseBean> bioVideoList;
    ArrayList<GetBookmarkModelView.ResponseBean> bioConceptList;
    ArrayList<GetBookmarkModelView.ResponseBean> bioQuestionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_book_mark_details);
        binding.menu.setOnClickListener(this);
        binding.analytic.setOnClickListener(this);
        binding.test.setOnClickListener(this);
        binding.menulearn.setOnClickListener(this);
        binding.doubts.setOnClickListener(this);
        binding.conceptButton.setOnClickListener(this);
        binding.VideosButton.setOnClickListener(this);
        binding.QuestionSetButton.setOnClickListener(this);

        bookmarkedList = new ArrayList<>();
        mathVideoList = new ArrayList<>();
        mathConceptList = new ArrayList<>();
        mathQuestionList = new ArrayList<>();
        chemVideoList = new ArrayList<>();
        chemConceptList = new ArrayList<>();
        chemQuestionList = new ArrayList<>();
        phyVideoList = new ArrayList<>();
        phyConceptList = new ArrayList<>();
        phyQuestionList = new ArrayList<>();
        bioVideoList = new ArrayList<>();
        bioConceptList = new ArrayList<>();
        bioQuestionList = new ArrayList<>();

        if(getIntent() != null){
            subName = getIntent().getStringExtra("subject");
            bookmarkedList = (ArrayList<GetBookmarkModelView.ResponseBean>) getIntent().getSerializableExtra("bookmarkList");
        }

        setData();

    }

    public void setData(){
        if(bookmarkedList != null){
            if(bookmarkedList.size() > 0){
                for (int i=0; i<bookmarkedList.size(); i++) {
                    if (subName.equalsIgnoreCase("maths")) {
                        if (bookmarkedList.get(i).getSubject().equalsIgnoreCase("Maths")) {
                            if (bookmarkedList.get(i).getBookmarktype().equalsIgnoreCase("Videos")) {
                                mathVideoList.add(bookmarkedList.get(i));
                            } else if (bookmarkedList.get(i).getBookmarktype().equalsIgnoreCase("Concept")) {
                                mathConceptList.add(bookmarkedList.get(i));
                            } else if (bookmarkedList.get(i).getBookmarktype().equalsIgnoreCase("Questionsets")) {
                                mathQuestionList.add(bookmarkedList.get(i));
                            }
                        }
                    } else if (subName.equalsIgnoreCase("chemistry")) {
                        if (bookmarkedList.get(i).getSubject().equalsIgnoreCase("Chemistry")) {
                            if (bookmarkedList.get(i).getBookmarktype().equalsIgnoreCase("Videos")) {
                                chemVideoList.add(bookmarkedList.get(i));
                            } else if (bookmarkedList.get(i).getBookmarktype().equalsIgnoreCase("Concept")) {
                                chemConceptList.add(bookmarkedList.get(i));
                            } else if (bookmarkedList.get(i).getBookmarktype().equalsIgnoreCase("Questionsets")) {
                                chemQuestionList.add(bookmarkedList.get(i));
                            }
                        }
                    } else if (subName.equalsIgnoreCase("physics")) {
                        if (bookmarkedList.get(i).getSubject().equalsIgnoreCase("Physics")) {
                            if (bookmarkedList.get(i).getBookmarktype().equalsIgnoreCase("Videos")) {
                                phyVideoList.add(bookmarkedList.get(i));
                            } else if (bookmarkedList.get(i).getBookmarktype().equalsIgnoreCase("Concept")) {
                                phyConceptList.add(bookmarkedList.get(i));
                            } else if (bookmarkedList.get(i).getBookmarktype().equalsIgnoreCase("Questionsets")) {
                                phyQuestionList.add(bookmarkedList.get(i));
                            }
                        }
                    } else if (subName.equalsIgnoreCase("biology")) {
                        if (bookmarkedList.get(i).getSubject().equalsIgnoreCase("Biology")) {
                            if (bookmarkedList.get(i).getBookmarktype().equalsIgnoreCase("Videos")) {
                                bioVideoList.add(bookmarkedList.get(i));
                            } else if (bookmarkedList.get(i).getBookmarktype().equalsIgnoreCase("Concept")) {
                                bioConceptList.add(bookmarkedList.get(i));
                            } else if (bookmarkedList.get(i).getBookmarktype().equalsIgnoreCase("Questionsets")) {
                                bioQuestionList.add(bookmarkedList.get(i));
                            }
                        }
                    }

                }

            }
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.menulearn:
                Intent menuLIntent = new Intent(BookMarkDetails.this, ChooseSubject.class);
                startActivity(menuLIntent);
                break;
            case R.id.test:
                Intent testIntent = new Intent(BookMarkDetails.this, Test.class);
                testIntent.putExtra("data", "test");
                startActivity(testIntent);
                break;
            case R.id.analytic:
                Intent testIntent1 = new Intent(BookMarkDetails.this, Reports.class);
                testIntent1.putExtra("data", "Analytics");
                startActivity(testIntent1);
                break;
            case R.id.doubts:
                Intent doubtsIntent = new Intent(BookMarkDetails.this, ViewBookmarks.class);
                startActivity(doubtsIntent);
                break;
            case R.id.menu:
                Intent menuIntent = new Intent(BookMarkDetails.this, MenuItem.class);
                startActivity(menuIntent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_in_left);
                break;

            case R.id.conceptButton:
                Intent conceptIntent = new Intent(BookMarkDetails.this, ConceptActivity.class);
                if(subName.equalsIgnoreCase("maths")) {
                    conceptIntent.putExtra("sName", "Maths");
                    conceptIntent.putExtra("type", "bookmark");
                } else if(subName.equalsIgnoreCase("chemistry")) {
                    conceptIntent.putExtra("sName", "chemistry");
                    conceptIntent.putExtra("type", "bookmark");

                } else if (subName.equalsIgnoreCase("physics")){
                    conceptIntent.putExtra("sName", "physics");
                    conceptIntent.putExtra("type", "bookmark");

                } else if (subName.equalsIgnoreCase("Biology")){
                    conceptIntent.putExtra("sName", "Biology");
                    conceptIntent.putExtra("type", "bookmark");

                }
                startActivity(conceptIntent);
                break;
            case R.id.VideosButton:
                Intent videoIntent = new Intent(BookMarkDetails.this, VideoActivity.class);
                if(subName.equalsIgnoreCase("maths")) {
                    videoIntent.putExtra("sName", "Maths");
                    videoIntent.putExtra("type", "bookmark");
                } else if(subName.equalsIgnoreCase("chemistry")) {
                    videoIntent.putExtra("sName", "chemistry");
                    videoIntent.putExtra("type", "bookmark");

                } else if (subName.equalsIgnoreCase("physics")){
                    videoIntent.putExtra("sName", "physics");
                    videoIntent.putExtra("type", "bookmark");

                } else if (subName.equalsIgnoreCase("Biology")){
                   videoIntent.putExtra("sName", "Biology");
                   videoIntent.putExtra("type", "bookmark");

                }
                startActivity(videoIntent);

                break;
            case R.id.Question_Set_button:
                Intent queIntent = new Intent(BookMarkDetails.this, QuestionSetActivity.class);
                if(subName.equalsIgnoreCase("maths")) {
                    queIntent.putExtra("sName", "Maths");
                    queIntent.putExtra("type", "bookmark");
                } else if(subName.equalsIgnoreCase("chemistry")) {
                    queIntent.putExtra("sName", "chemistry");
                    queIntent.putExtra("type", "bookmark");

                } else if (subName.equalsIgnoreCase("physics")){
                    queIntent.putExtra("sName", "physics");
                    queIntent.putExtra("type", "bookmark");

                } else if (subName.equalsIgnoreCase("Biology")){
                    queIntent.putExtra("sName", "Biology");
                    queIntent.putExtra("type", "bookmark");

                }
                startActivity(queIntent);
                break;
        }
    }
}
