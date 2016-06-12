package org.jcapps.statebirds;

/**
 * Created by JC on 6/10/16.
 */
public class Question {

    String mState;
    String mBird;
    String mDescription;
    boolean isAnswer;

//    public Question() {
//        }

    public Question(String state, String bird, String description, boolean isAns) {
        this.mState = state;
        this.mBird = bird;
        this.mDescription = description;
        this.isAnswer = isAns;
    }

        public String getmState() {
            return mState;
        }

        public void setmState(String state) {
            mState = state;
        }

        public String getmBird() {
            return mBird;
        }

        public void setmBird(String bird) {
            mBird = bird;
        }

        public String getmDescription() {
            return mDescription;
        }

        public void setmDescription(String description) {
            mDescription = description;
        }


    }

