package io.github.QCute.CodeCase;

import com.intellij.openapi.actionSystem.DataContext;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.editor.Caret;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.EditorModificationUtil;
import com.intellij.openapi.editor.actionSystem.EditorActionHandler;
import com.intellij.openapi.editor.actionSystem.EditorWriteActionHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ToggleCodeCaseHandler extends EditorActionHandler {

    ToggleCodeCaseHandler() {
        super(true);
    }

    @Override
    protected final void doExecute(@NotNull final Editor editor, @Nullable final Caret caret, final DataContext dataContext) {

        String text = editor.getSelectionModel().getSelectedText();
        if (text == null || text.isEmpty()) {
            editor.getSelectionModel().selectWordAtCaret(true);
            text = editor.getSelectionModel().getSelectedText();
        }
        assert text != null;
        final String newText = Converter.transform(text);
        Runnable runnable = () -> {
            int start = editor.getSelectionModel().getSelectionStart();
            EditorModificationUtil.insertStringAtCaret(editor, newText);
            editor.getSelectionModel().setSelection(start, start + newText.length());
        };
        ApplicationManager.getApplication().runWriteAction(runnable);

        new EditorWriteActionHandler(false) {@Override public void executeWriteAction(Editor e, @Nullable Caret c, DataContext dc) { }}.doExecute(editor, caret, dataContext);
    }



}