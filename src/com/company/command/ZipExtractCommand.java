package com.company.command;

import com.company.ConsoleHelper;
import com.company.ZipFileManager;
import com.company.exception.PathIsNotFoundException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ZipExtractCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        try {
            ConsoleHelper.writeMessage("Unarchiving.");

            ZipFileManager zipFileManager = getZipFileManager();

            ConsoleHelper.writeMessage("Write path for unarchive:");
            Path destinationPath = Paths.get(ConsoleHelper.readString());
            zipFileManager.extractAll(destinationPath);

            ConsoleHelper.writeMessage("Unarchived.");

        } catch (PathIsNotFoundException e) {
            ConsoleHelper.writeMessage("Wrong path for archive.");
        }
    }
}
