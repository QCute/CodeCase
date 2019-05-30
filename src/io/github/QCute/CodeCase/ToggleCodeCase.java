package io.github.QCute.CodeCase;

import com.intellij.openapi.editor.actionSystem.EditorAction;

public class ToggleCodeCase extends EditorAction {

    public ToggleCodeCase() {
        super(new ToggleCodeCaseHandler());
    }

}
