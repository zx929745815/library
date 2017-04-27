package xtu.library.entity;

import java.util.List;

/**
 * 用于向页面传递所有读者的数据
 * @author 郑旭
 * 上午10:50:12
 */
public class ReaderData {
	private List<Reader> data;

	public List<Reader> getData() {
		return data;
	}

	public void setData(List<Reader> data) {
		this.data = data;
	}
}
