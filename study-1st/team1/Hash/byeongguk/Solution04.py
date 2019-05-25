#! /usr/bin/env bash
# -*- coding: utf-8 -*-

def solution(genres, plays):
    albums = {}
    best_album = []

    # 장르별 노래 분류 저장 및 총 실행 횟수 저장
    for unique_id, (genre, play) in enumerate(zip(genres, plays)):
        if genre not in list(albums.keys()):
            albums[genre] = {}
            albums[genre]['songs'] = []
            albums[genre]['plays'] = 0

        albums[genre]['songs'].append((unique_id, play))
        albums[genre]['plays'] += play

    # 장르별 총 실행 횟수 기준 내림차순 정렬
    albums = sorted(albums.items(),
        key=lambda album: album[1]['plays'], reverse=True)

    # 장르 내 노래 실행 횟수 기준 내림차순 정렬 및 베스트 앨범에 노래 삽입
    for album in albums:
        songs = sorted(album[1]['songs'],
            key=lambda song: song[1], reverse=True)

        for song in songs[:2]:
            best_album.append(song[0])

    return best_album
