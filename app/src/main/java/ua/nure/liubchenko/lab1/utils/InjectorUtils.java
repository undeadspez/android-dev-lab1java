package ua.nure.liubchenko.lab1.utils;

import android.content.Context;

import ua.nure.liubchenko.lab1.data.NoteDatabase;
import ua.nure.liubchenko.lab1.data.NoteRepository;
import ua.nure.liubchenko.lab1.viewmodels.CreateNoteViewModelFactory;
import ua.nure.liubchenko.lab1.viewmodels.FilterViewModelFactory;
import ua.nure.liubchenko.lab1.viewmodels.ShowNoteViewModelFactory;
import ua.nure.liubchenko.lab1.viewmodels.NoteListViewModelFactory;

public class InjectorUtils {

    public static NoteRepository getNoteRepository(Context context) {
        return NoteRepository.getInstance(
                NoteDatabase.getDatabase(context.getApplicationContext()).noteDao());
    }

    public static NoteListViewModelFactory provideNoteListViewModelFactory(Context context) {
        return new NoteListViewModelFactory(getNoteRepository(context));
    }

    public static ShowNoteViewModelFactory provideNoteDetailsViewModelFactory(Context context,
                                                                              long noteId) {
        return new ShowNoteViewModelFactory(getNoteRepository(context), noteId);
    }

    public static CreateNoteViewModelFactory provideCreateNoteViewModelFactory(Context context) {
        return new CreateNoteViewModelFactory(getNoteRepository(context));
    }

    public static FilterViewModelFactory provideFilterViewModelFactory(Context context) {
        return new FilterViewModelFactory(getNoteRepository(context));
    }
}
