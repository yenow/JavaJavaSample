package junit5;

/**
 * packageName : junit5
 * fileName : Study
 * author : 윤신영
 * date : 2022-01-13
 * description :
 * ===========================================================
 * DATE      AUTHOR      NOTE
 * -----------------------------------------------------------
 * 2022-01-13   윤신영     최초 생성
 */
public class Study {

    private StudyStatus studyStatus;

    public StudyStatus getStatus() {
        return this.studyStatus;
    }

    public void setStudyStatus(StudyStatus studyStatus) {
        this.studyStatus = studyStatus;
    }
}
