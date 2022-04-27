package pt.isec.pa.four_in_a_row.model.memento;

public interface IOriginator {

    IMemento save();
    void restore(IMemento memento);

}
