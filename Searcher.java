public static Pagination getResultPage(Searcher searcher, TopDocs docs,
		int pageNo, int pageSize) throws CorruptIndexException, IOException {
	List<Integer> list = new ArrayList<Integer>(pageSize);
	ScoreDoc[] hits = docs.scoreDocs;
	int endIndex = pageNo * pageSize;
	int len = hits.length;
	if (endIndex > len) {
		endIndex = len;
	}
	for (int i = (pageNo - 1) * pageSize; i < endIndex; i++) {
		Document d = searcher.doc(hits[i].doc);
		list.add(Integer.valueOf(d.getField(ID).stringValue()));
	}
	return new Pagination(pageNo, pageSize, docs.totalHits, list);
}
