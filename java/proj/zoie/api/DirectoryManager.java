package proj.zoie.api;

import java.io.IOException;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.Date;

import org.apache.lucene.store.Directory;

public interface DirectoryManager
{
  static final String INDEX_DIRECTORY = "index.directory";

  Directory getDirectory() throws IOException;
  
  Directory getDirectory(boolean create) throws IOException;
  
  long getVersion() throws IOException;
  
  void setVersion(long version) throws IOException;

  Date getLastIndexModifiedTime();

  String getPath();
  
  void purge();
  
  boolean exists();
  
  boolean transferFromChannelToFile(ReadableByteChannel channel, String fileName) throws IOException;

  long transferFromFileToChannel(String fileName, WritableByteChannel channel) throws IOException;
}
