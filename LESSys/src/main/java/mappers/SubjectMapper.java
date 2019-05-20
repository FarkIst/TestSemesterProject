package mappers;

import units.Subject;

public class SubjectMapper extends GenericMapper<Subject> implements SubjectInterface{
    public SubjectMapper() {
        super(Subject.class);
    }

    public SubjectMapper(String PU) {
        super(PU, Subject.class);
    }
}
